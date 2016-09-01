package io.jaylim.compiler.ast.pojos.classes.members;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.parameters.FormalParameterList;
import io.jaylim.compiler.ast.pojos.parameters.MultiFormalParameterList;
import io.jaylim.compiler.ast.pojos.types.Dims;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MethodDeclarator extends AstNode {

  private final String identifier;
  private final FormalParameterList formalParameterList;
  private final Dims dims;

  public MethodDeclarator(Range range, AstNode parent,
                          String identifier,
                          FormalParameterList formalParameterList,
                          Dims dims) {
    super(range, parent);
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
    this.dims = dims;
  }

  public MethodDeclarator(Position start, Position end, AstNode parent,
                          String identifier,
                          FormalParameterList formalParameterList,
                          Dims dims) {
    super(start, end, parent);
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
    this.dims = dims;
  }

  public MethodDeclarator(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                          String identifier,
                          FormalParameterList formalParameterList,
                          Dims dims) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
    this.dims = dims;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty("FormalParameters")
  public FormalParameterList getFormalParameterList() {
    return formalParameterList;
  }

  @JsonProperty("Dims")
  public Dims getDims() {
    return dims;
  }
}
