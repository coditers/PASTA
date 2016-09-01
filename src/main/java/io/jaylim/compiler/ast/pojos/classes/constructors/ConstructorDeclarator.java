package io.jaylim.compiler.ast.pojos.classes.constructors;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.parameters.FormalParameterList;
import io.jaylim.compiler.ast.pojos.parameters.MultiFormalParameterList;
import io.jaylim.compiler.ast.pojos.types.TypeParameter;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ConstructorDeclarator extends AstNode {

  private final List<TypeParameter> typeParameterList;
  private final String identifier;
  private final FormalParameterList formalParameterList;

  public ConstructorDeclarator(Range range, AstNode parent,
                               List<TypeParameter> typeParameterList,
                               String identifier,
                               FormalParameterList formalParameterList) {
    super(range, parent);
    this.typeParameterList = typeParameterList;
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
  }

  public ConstructorDeclarator(Position start, Position end, AstNode parent,
                               List<TypeParameter> typeParameterList,
                               String identifier,
                               FormalParameterList formalParameterList) {
    super(start, end, parent);
    this.typeParameterList = typeParameterList;
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
  }

  public ConstructorDeclarator(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                               List<TypeParameter> typeParameterList,
                               String identifier,
                               FormalParameterList formalParameterList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeParameterList = typeParameterList;
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
  }

  @JsonProperty("TypeParameterList")
  public List<TypeParameter> getTypeParameterList() {
    return typeParameterList;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty("FormalParameterList")
  public FormalParameterList getFormalParameterList() {
    return formalParameterList;
  }
}
