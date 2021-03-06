package io.jaylim.compiler.ast.pojos.types.unann;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannUnitInterfaceType extends UnannUnitClassOrInterfaceType {

  private final UnannUnitClassType unannUnitClassType;

  public UnannUnitInterfaceType(Range range, AstNode parent,
                                UnannUnitClassType unannUnitClassType) {
    super(range, parent);
    this.unannUnitClassType = unannUnitClassType;
  }

  public UnannUnitInterfaceType(Position start, Position end, AstNode parent,
                                UnannUnitClassType unannUnitClassType) {
    super(start, end, parent);
    this.unannUnitClassType = unannUnitClassType;
  }

  public UnannUnitInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                UnannUnitClassType unannUnitClassType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unannUnitClassType = unannUnitClassType;
  }

  @JsonProperty("UnannUnitClassType")
  public UnannUnitClassType getUnannUnitClassType() {
    return unannUnitClassType;
  }
}
