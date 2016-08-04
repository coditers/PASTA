package codit.ast.pojos.expressions.primaries.fieldaccess;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.PrimaryExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class FieldAccess extends PrimaryExpression {

  public FieldAccess(Range range, AstNode parent) {
    super(range, parent);
  }

  public FieldAccess(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public FieldAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
