package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;

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
}
