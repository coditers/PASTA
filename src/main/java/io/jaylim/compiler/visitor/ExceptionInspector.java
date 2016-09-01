package io.jaylim.compiler.visitor;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;

import io.jaylim.compiler.gencode.JavaBaseVisitor;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ExceptionInspector extends JavaBaseVisitor<String> {

  @Override
  public String visitErrorNode(ErrorNode node) {

    return "ERROR";
  }

  @Override
  public String visitChildren(RuleNode node) {
    ParserRuleContext ctx = (ParserRuleContext) node.getRuleContext();

    String result;
    if(ctx.exception == null) {
      result = defaultResult();
    } else {
      result = "ERROR";
    }

    int n = node.getChildCount();
    for (int i=0; i<n; i++) {
      if (!shouldVisitNextChild(node, result)) {
        break;
      }

      ParseTree c = node.getChild(i);
      String childResult = c.accept(this);
      result = aggregateResult(result, childResult);
    }

    return result;
  }

  @Override
  protected String aggregateResult(String aggregate, String nextResult) {

    if ( aggregate != null && aggregate.equals( "ERROR" ) ) {
      return aggregate;
    }
    return nextResult;
  }
}
