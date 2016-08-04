package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ImplAndExpression extends AndExpression {
  private final AndExpression andExpression;
  private final EqualityExpression equalityExpression;

  public ImplAndExpression(Range range, AstNode parent,
                           AndExpression andExpression,
                           EqualityExpression equalityExpression) {
    super(range, parent);
    this.andExpression = andExpression;
    this.equalityExpression = equalityExpression;
  }

  public ImplAndExpression(Position start, Position end, AstNode parent,
                           AndExpression andExpression,
                           EqualityExpression equalityExpression) {
    super(start, end, parent);
    this.andExpression = andExpression;
    this.equalityExpression = equalityExpression;
  }

  public ImplAndExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                           AndExpression andExpression,
                           EqualityExpression equalityExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.andExpression = andExpression;
    this.equalityExpression = equalityExpression;
  }
}
