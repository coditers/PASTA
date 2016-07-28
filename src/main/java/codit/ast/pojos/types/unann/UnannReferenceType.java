package codit.ast.pojos.types.unann;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class UnannReferenceType extends UnannType {

  public UnannReferenceType(Range range, AstNode parent) {
    super(range, parent);
  }

  public UnannReferenceType(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public UnannReferenceType(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
