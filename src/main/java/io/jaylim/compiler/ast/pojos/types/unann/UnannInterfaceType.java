package io.jaylim.compiler.ast.pojos.types.unann;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannInterfaceType extends UnannMultiClassOrInterfaceType {

  private final UnannClassType unannClassType;

  public UnannInterfaceType(Range range, AstNode parent,
                            UnannClassType unannClassType) {
    super(range, parent);
    this.unannClassType = unannClassType;
  }

  public UnannInterfaceType(Position start, Position end, AstNode parent,
                            UnannClassType unannClassType) {
    super(start, end, parent);
    this.unannClassType = unannClassType;
  }

  public UnannInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                            UnannClassType unannClassType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unannClassType = unannClassType;
  }

  @JsonProperty("UnannClassType")
  public UnannClassType getUnannClassType() {
    return unannClassType;
  }
}
