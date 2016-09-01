package io.jaylim.compiler.ast.pojos.expressions.lambdas;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.parameters.FormalParameterList;
import io.jaylim.compiler.ast.pojos.parameters.MultiFormalParameterList;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class FormalLambdaParameters extends LambdaParameters {

  private final FormalParameterList formalParameterList;

  public FormalLambdaParameters(Range range, AstNode parent,
                                FormalParameterList formalParameterList) {
    super(range, parent);
    this.formalParameterList = formalParameterList;
  }

  public FormalLambdaParameters(Position start, Position end, AstNode parent,
                                FormalParameterList formalParameterList) {
    super(start, end, parent);
    this.formalParameterList = formalParameterList;
  }

  public FormalLambdaParameters(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                FormalParameterList formalParameterList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.formalParameterList = formalParameterList;
  }

  @JsonProperty("FormalParameterList")
  public FormalParameterList getFormalParameterList() {
    return formalParameterList;
  }
}
