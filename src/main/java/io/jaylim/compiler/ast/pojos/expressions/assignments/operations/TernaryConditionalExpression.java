package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TernaryConditionalExpression extends ConditionalExpression {
  private final ConditionalOrExpression conditionalOrExpression;
  private final Expression expression;
  private final ConditionalExpression conditionalExpression;

  public TernaryConditionalExpression(Range range, AstNode parent,
                                      ConditionalOrExpression conditionalOrExpression,
                                      Expression expression,
                                      ConditionalExpression conditionalExpression) {
    super(range, parent);
    this.conditionalOrExpression = conditionalOrExpression;
    this.expression = expression;
    this.conditionalExpression = conditionalExpression;
  }

  public TernaryConditionalExpression(Position start, Position end, AstNode parent,
                                      ConditionalOrExpression conditionalOrExpression,
                                      Expression expression,
                                      ConditionalExpression conditionalExpression) {
    super(start, end, parent);
    this.conditionalOrExpression = conditionalOrExpression;
    this.expression = expression;
    this.conditionalExpression = conditionalExpression;
  }

  public TernaryConditionalExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                      ConditionalOrExpression conditionalOrExpression,
                                      Expression expression,
                                      ConditionalExpression conditionalExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.conditionalOrExpression = conditionalOrExpression;
    this.expression = expression;
    this.conditionalExpression = conditionalExpression;
  }

  @JsonProperty("ConditionalOrExpression")
  public ConditionalOrExpression getConditionalOrExpression() {
    return conditionalOrExpression;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }

  @JsonProperty("ConditionalExpression")
  public ConditionalExpression getConditionalExpression() {
    return conditionalExpression;
  }
}
