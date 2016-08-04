package codit.ast.pojos.expressions.primaries;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class PrimaryExpression extends AstNode {

  public PrimaryExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public PrimaryExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public PrimaryExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
