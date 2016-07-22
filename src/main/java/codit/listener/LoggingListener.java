package codit.listener;

import org.antlr.v4.runtime.ParserRuleContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import codit.gencode.JavaBaseListener;
import codit.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LoggingListener extends JavaBaseListener {

  private static final Logger logger = LoggerFactory.getLogger(LoggingListener.class);


  @Override
  public void enterEveryRule(ParserRuleContext ctx) {
    logger.info("[ENTER] " + ctx.getRuleIndex() + " ( getText : " + ctx.getText() + " | depth : "+ ctx.depth() + " | toStringTree : " + ctx.toStringTree(Arrays.asList(JavaParser.ruleNames)) + " | toString : "+ ctx.toString(Arrays.asList(JavaParser.ruleNames)) + " )");
    super.enterEveryRule(ctx);
  }

  @Override
  public void exitEveryRule(ParserRuleContext ctx) {
    logger.info("[EXIT_] " + ctx.getRuleIndex() + " ( getText : " + ctx.getText() + " | depth : "+ ctx.depth() + " | toStringTree : " + ctx.toStringTree(Arrays.asList(JavaParser.ruleNames)) + " | toString : "+ ctx.toString(Arrays.asList(JavaParser.ruleNames)) + " )");
    super.exitEveryRule(ctx);
  }

}
