package io.jaylim.compiler.ast.pojos.types.unann;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

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

  @JsonProperty("LfUnannUnitClassType")
  public LfUnannUnitClassType getLfUnannUnitClassType() {
    return lfUnannUnitClassType;
  }
}
