package codit.ast.pojos.types.unann;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LfUnannUnitInterfaceType extends UnannUnitClassOrInterfaceType {

  private final LfUnannUnitClassType lfUnannUnitClassType;

  public LfUnannUnitInterfaceType(Range range, AstNode parent, LfUnannUnitClassType lfUnannUnitClassType) {
    super(range, parent);
    this.lfUnannUnitClassType = lfUnannUnitClassType;
  }

  public LfUnannUnitInterfaceType(Position start, Position end, AstNode parent, LfUnannUnitClassType lfUnannUnitClassType) {
    super(start, end, parent);
    this.lfUnannUnitClassType = lfUnannUnitClassType;
  }

  public LfUnannUnitInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent, LfUnannUnitClassType lfUnannUnitClassType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.lfUnannUnitClassType = lfUnannUnitClassType;
  }
}
