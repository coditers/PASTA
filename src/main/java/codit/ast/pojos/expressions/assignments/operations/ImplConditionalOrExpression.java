package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ImplConditionalOrExpression extends ConditionalOrExpression {
  private final ConditionalOrExpression conditionalOrExpression;
  private final ConditionalAndExpression conditionalAndExpression;

  public ImplConditionalOrExpression(Range range, AstNode parent,
                                     ConditionalOrExpression conditionalOrExpression,
                                     ConditionalAndExpression conditionalAndExpression) {
    super(range, parent);
    this.conditionalOrExpression = conditionalOrExpression;
    this.conditionalAndExpression = conditionalAndExpression;
  }

  public ImplConditionalOrExpression(Position start, Position end, AstNode parent,
                                     ConditionalOrExpression conditionalOrExpression,
                                     ConditionalAndExpression conditionalAndExpression) {
    super(start, end, parent);
    this.conditionalOrExpression = conditionalOrExpression;
    this.conditionalAndExpression = conditionalAndExpression;
  }

  public ImplConditionalOrExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                     ConditionalOrExpression conditionalOrExpression,
                                     ConditionalAndExpression conditionalAndExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.conditionalOrExpression = conditionalOrExpression;
    this.conditionalAndExpression = conditionalAndExpression;
  }
}
