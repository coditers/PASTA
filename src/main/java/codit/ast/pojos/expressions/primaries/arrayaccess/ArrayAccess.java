package codit.ast.pojos.expressions.primaries.arrayaccess;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.PrimaryExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ArrayAccess extends PrimaryExpression {

  public ArrayAccess(Range range, AstNode parent) {
    super(range, parent);
  }

  public ArrayAccess(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ArrayAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
