package codit.ast.pojos.expressions.lambdas;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.parameters.MultiFormalParameterList;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class FormalLambdaParameters extends LambdaParameters {

  private final MultiFormalParameterList formalParameterList;

  public FormalLambdaParameters(Range range, AstNode parent,
                                MultiFormalParameterList formalParameterList) {
    super(range, parent);
    this.formalParameterList = formalParameterList;
  }

  public FormalLambdaParameters(Position start, Position end, AstNode parent,
                                MultiFormalParameterList formalParameterList) {
    super(start, end, parent);
    this.formalParameterList = formalParameterList;
  }

  public FormalLambdaParameters(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                MultiFormalParameterList formalParameterList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.formalParameterList = formalParameterList;
  }

  @JsonProperty("FormalParameterList")
  public MultiFormalParameterList getFormalParameterList() {
    return formalParameterList;
  }
}
