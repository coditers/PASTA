package io.jaylim.compiler.ast.pojos.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jay Lim
 * @date 8/25/2016
 */
public class SingleLastFormalParameter extends LastFormalParameter {

  private final FormalParameter formalParameter;

  public SingleLastFormalParameter(Range range, AstNode parent, FormalParameter formalParameter) {
    super(range, parent);
    this.formalParameter = formalParameter;
  }

  public SingleLastFormalParameter(Position start, Position end, AstNode parent, FormalParameter formalParameter) {
    super(start, end, parent);
    this.formalParameter = formalParameter;
  }

  public SingleLastFormalParameter(int startLine, int startCol, int endLine, int endCol, AstNode parent, FormalParameter formalParameter) {
    super(startLine, startCol, endLine, endCol, parent);
    this.formalParameter = formalParameter;
  }

  @JsonProperty("FormalParameter")
  public FormalParameter getFormalParameter() {
    return formalParameter;
  }
}
