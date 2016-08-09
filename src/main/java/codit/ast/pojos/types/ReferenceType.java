package codit.ast.pojos.types;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ReferenceType extends Type implements Arguable {

  public ReferenceType(Range range, AstNode parent) {
    super(range, parent);
  }

  public ReferenceType(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ReferenceType(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
