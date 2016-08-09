package codit.ast.pojos.types;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class TypeBound extends AstNode {

  public TypeBound(Range range, AstNode parent) {
    super(range, parent);
  }

  public TypeBound(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public TypeBound(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
