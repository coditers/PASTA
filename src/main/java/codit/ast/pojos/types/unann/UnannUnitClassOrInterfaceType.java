package codit.ast.pojos.types.unann;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.types.Type;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannUnitClassOrInterfaceType extends Type {
  public UnannUnitClassOrInterfaceType(Range range, AstNode parent) {
    super(range, parent);
  }

  public UnannUnitClassOrInterfaceType(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public UnannUnitClassOrInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
