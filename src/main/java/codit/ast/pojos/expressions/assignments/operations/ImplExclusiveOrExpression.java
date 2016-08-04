package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ImplExclusiveOrExpression extends ExclusiveOrExpression {

  private final ExclusiveOrExpression exclusiveOrExpression;
  private final AndExpression andExpression;

  public ImplExclusiveOrExpression(Range range, AstNode parent,
                                   ExclusiveOrExpression exclusiveOrExpression,
                                   AndExpression andExpression) {
    super(range, parent);
    this.exclusiveOrExpression = exclusiveOrExpression;
    this.andExpression = andExpression;
  }

  public ImplExclusiveOrExpression(Position start, Position end, AstNode parent,
                                   ExclusiveOrExpression exclusiveOrExpression,
                                   AndExpression andExpression) {
    super(start, end, parent);
    this.exclusiveOrExpression = exclusiveOrExpression;
    this.andExpression = andExpression;
  }

  public ImplExclusiveOrExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   ExclusiveOrExpression exclusiveOrExpression,
                                   AndExpression andExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.exclusiveOrExpression = exclusiveOrExpression;
    this.andExpression = andExpression;
  }
}
