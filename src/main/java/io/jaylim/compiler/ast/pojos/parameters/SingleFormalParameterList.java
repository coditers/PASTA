package io.jaylim.compiler.ast.pojos.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jay Lim
 * @since  8/25/2016
 */
public class SingleFormalParameterList extends FormalParameterList {

  private final LastFormalParameter lastFormalParameter;

  public SingleFormalParameterList(Range range, AstNode parent, LastFormalParameter lastFormalParameter) {
    super(range, parent);
    this.lastFormalParameter = lastFormalParameter;
  }

  public SingleFormalParameterList(Position start, Position end, AstNode parent, LastFormalParameter lastFormalParameter) {
    super(start, end, parent);
    this.lastFormalParameter = lastFormalParameter;
  }

  public SingleFormalParameterList(int startLine, int startCol, int endLine, int endCol, AstNode parent, LastFormalParameter lastFormalParameter) {
    super(startLine, startCol, endLine, endCol, parent);
    this.lastFormalParameter = lastFormalParameter;
  }

  @JsonProperty("LastFormalParameter")
  public LastFormalParameter getLastFormalParameter() {
    return lastFormalParameter;
  }
}
