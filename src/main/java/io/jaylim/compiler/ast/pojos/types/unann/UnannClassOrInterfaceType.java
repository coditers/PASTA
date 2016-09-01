package io.jaylim.compiler.ast.pojos.types.unann;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannClassOrInterfaceType extends UnannReferenceType implements UnannArrayable {
  private final boolean isInterface;
  private final UnannUnitClassOrInterfaceType unannUnitClassOrInterfaceType;   // Target class
  private final List<UnannUnitClassOrInterfaceType> unannClassOrInterfaceType; // Packaging class

  public UnannClassOrInterfaceType(Range range, AstNode parent,
                                   boolean isInterface,
                                   UnannUnitClassOrInterfaceType unannUnitClassOrInterfaceType,
                                   List<UnannUnitClassOrInterfaceType> unannClassOrInterfaceType) {
    super(range, parent);
    this.isInterface = isInterface;
    this.unannUnitClassOrInterfaceType = unannUnitClassOrInterfaceType;
    this.unannClassOrInterfaceType = unannClassOrInterfaceType;
  }

  public UnannClassOrInterfaceType(Position start, Position end, AstNode parent,
                                   boolean isInterface,
                                   UnannUnitClassOrInterfaceType unannUnitClassOrInterfaceType,
                                   List<UnannUnitClassOrInterfaceType> unannClassOrInterfaceType) {
    super(start, end, parent);
    this.isInterface = isInterface;
    this.unannUnitClassOrInterfaceType = unannUnitClassOrInterfaceType;
    this.unannClassOrInterfaceType = unannClassOrInterfaceType;
  }

  public UnannClassOrInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   boolean isInterface,
                                   UnannUnitClassOrInterfaceType unannUnitClassOrInterfaceType,
                                   List<UnannUnitClassOrInterfaceType> unannClassOrInterfaceType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.isInterface = isInterface;
    this.unannUnitClassOrInterfaceType = unannUnitClassOrInterfaceType;
    this.unannClassOrInterfaceType = unannClassOrInterfaceType;
  }

  @JsonProperty("isInterface")
  public boolean isInterface() {
    return isInterface;
  }

  @JsonProperty("UnannUnitClassOrInterfaceType")
  public UnannUnitClassOrInterfaceType getUnannUnitClassOrInterfaceType() {
    return unannUnitClassOrInterfaceType;
  }

  @JsonProperty("UnannClassOrInterfaceType")
  public List<UnannUnitClassOrInterfaceType> getUnannClassOrInterfaceType() {
    return unannClassOrInterfaceType;
  }
}
