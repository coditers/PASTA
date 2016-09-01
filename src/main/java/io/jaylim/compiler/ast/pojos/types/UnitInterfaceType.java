package io.jaylim.compiler.ast.pojos.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

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

  @JsonProperty("UnitClassType")
  public UnitClassType getUnitClassType() {
    return unitClassType;
  }
}
