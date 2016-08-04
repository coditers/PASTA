package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class MultiplicativeExpression extends AdditiveExpression {
  public MultiplicativeExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public MultiplicativeExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public MultiplicativeExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
