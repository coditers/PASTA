package io.jaylim.compiler.ast.pojos.expressions.primaries.arrayaccess;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.expressions.assignments.LeftHandSide;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.names.ExpressionName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class DefaultPrimaryExpressionArrayAccess extends ArrayAccess
    implements DefaultArrayDefaultPrimary, LeftHandSide {

  private final ExpressionName expressionName;
  private final Expression firstExpression;

  //private final List<LfArrayDefaultPrimary> lfArrayDefaultPrimaryList;
  private final List<Expression> expressionList;

  public DefaultPrimaryExpressionArrayAccess(Range range, AstNode parent,
                                             ExpressionName expressionName,
                                             Expression firstExpression,
                                             //List<LfArrayDefaultPrimary> lfArrayDefaultPrimaryList,
                                             List<Expression> expressionList) {
    super(range, parent);
    this.expressionName = expressionName;
    this.firstExpression = firstExpression;
    //this.lfArrayDefaultPrimaryList = lfArrayDefaultPrimaryList;
    this.expressionList = expressionList;
  }

  public DefaultPrimaryExpressionArrayAccess(Position start, Position end, AstNode parent,
                                             ExpressionName expressionName,
                                             Expression firstExpression,
                                             //List<LfArrayDefaultPrimary> lfArrayDefaultPrimaryList,
                                             List<Expression> expressionList) {
    super(start, end, parent);
    this.expressionName = expressionName;
    this.firstExpression = firstExpression;
    //this.lfArrayDefaultPrimaryList = lfArrayDefaultPrimaryList;
    this.expressionList = expressionList;
  }

  public DefaultPrimaryExpressionArrayAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                             ExpressionName expressionName,
                                             Expression firstExpression,
                                             //List<LfArrayDefaultPrimary> lfArrayDefaultPrimaryList,
                                             List<Expression> expressionList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expressionName = expressionName;
    this.firstExpression = firstExpression;
    //this.lfArrayDefaultPrimaryList = lfArrayDefaultPrimaryList;
    this.expressionList = expressionList;
  }

  @JsonProperty("ExpressionName")
  public ExpressionName getExpressionName() {
    return expressionName;
  }

  @JsonProperty("Expression")
  public Expression getFirstExpression() {
    return firstExpression;
  }

  @JsonProperty("ExpressionList")
  public List<Expression> getExpressionList() {
    return expressionList;
  }
}
