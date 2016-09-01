package io.jaylim.compiler.ast.pojos.types.unann;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.types.TypeArgument;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannUnitClassType extends UnannUnitClassOrInterfaceType {

  private final String identifier;

  private final List<TypeArgument> typeArgumentList;

  public UnannUnitClassType(Range range, AstNode parent,
                            String identifier,
                            List<TypeArgument> typeArgumentList) {
    super(range, parent);
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  public UnannUnitClassType(Position start, Position end, AstNode parent,
                            String identifier,
                            List<TypeArgument> typeArgumentList) {
    super(start, end, parent);
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  public UnannUnitClassType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                            String identifier,
                            List<TypeArgument> typeArgumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty("TypeArgumentList")
  public List<TypeArgument> getTypeArgumentList() {
    return typeArgumentList;
  }
}
