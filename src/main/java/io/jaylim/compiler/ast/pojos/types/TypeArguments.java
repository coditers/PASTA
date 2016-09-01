package io.jaylim.compiler.ast.pojos.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * Newly added method.
 * @author Jisung Lim <iejisung@gmail.com>
 * @version 2.0
 * TODO - Change {@code List<TypeArgument> } to {@code TypeArguments }
 */
public class TypeArguments extends TypeArgumentsOrDiamond {

  private final List<TypeArgument> typeArgumentList;

  public TypeArguments(Range range, AstNode parent, List<TypeArgument> typeArgumentList) {
    super(range, parent);
    this.typeArgumentList = typeArgumentList;
  }

  public TypeArguments(Position start, Position end, AstNode parent, List<TypeArgument> typeArgumentList) {
    super(start, end, parent);
    this.typeArgumentList = typeArgumentList;
  }

  public TypeArguments(int startLine, int startCol, int endLine, int endCol, AstNode parent, List<TypeArgument> typeArgumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeArgumentList = typeArgumentList;
  }

  @JsonProperty("TypeArgumentList")
  public List<TypeArgument> getTypeArgumentList() {
    return typeArgumentList;
  }
}
