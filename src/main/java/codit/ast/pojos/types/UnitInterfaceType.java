package codit.ast.pojos.types;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnitInterfaceType extends UnitClassOrInterfaceType {

  private final UnitClassType unitClassType;

  public UnitInterfaceType(Range range, AstNode parent, UnitClassType unitClassType) {
    super(range, parent);
    this.unitClassType = unitClassType;
  }

  public UnitInterfaceType(Position start, Position end, AstNode parent, UnitClassType unitClassType) {
    super(start, end, parent);
    this.unitClassType = unitClassType;
  }

  public UnitInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent, UnitClassType unitClassType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unitClassType = unitClassType;
  }
}
