package codit.ast.pojos.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

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
