package codit.ast.pojos.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MultiFormalParameterList extends FormalParameterList {

  private final List<Parameter> parameterList;

  private final LastFormalParameter lastFormalParameter;

  public MultiFormalParameterList(Range range, AstNode parent,
                                  List<Parameter> parameterList,
                                  LastFormalParameter lastFormalParameter) {
    super(range, parent);
    this.parameterList = parameterList;
    this.lastFormalParameter = lastFormalParameter;
  }

  public MultiFormalParameterList(Position start, Position end, AstNode parent,
                                  List<Parameter> parameterList,
                                  LastFormalParameter lastFormalParameter) {
    super(start, end, parent);
    this.parameterList = parameterList;
    this.lastFormalParameter = lastFormalParameter;
  }

  public MultiFormalParameterList(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                  List<Parameter> parameterList,
                                  LastFormalParameter lastFormalParameter) {
    super(startLine, startCol, endLine, endCol, parent);
    this.parameterList = parameterList;
    this.lastFormalParameter = lastFormalParameter;
  }

  @JsonProperty("ParameterList")
  public List<Parameter> getParameterList() {
    return parameterList;
  }

  @JsonProperty("LastFormalParameter")
  public LastFormalParameter getLastFormalParameter() {
    return lastFormalParameter;
  }
}
