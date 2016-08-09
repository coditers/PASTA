package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ExclusiveOrExpression extends InclusiveOrExpression {
  public ExclusiveOrExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public ExclusiveOrExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ExclusiveOrExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
