package io.jaylim.compiler.ast.pojos.expressions.lambdas;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InferredFormalLambdaParameters extends LambdaParameters {

  private final List<String> identifierList;

  public InferredFormalLambdaParameters(Range range, AstNode parent,
                                        List<String> identifierList) {
    super(range, parent);
    this.identifierList = identifierList;
  }

  public InferredFormalLambdaParameters(Position start, Position end, AstNode parent,
                                        List<String> identifierList) {
    super(start, end, parent);
    this.identifierList = identifierList;
  }

  public InferredFormalLambdaParameters(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                        List<String> identifierList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifierList = identifierList;
  }

  @JsonProperty("IdentifierList")
  public List<String> getIdentifierList() {
    return identifierList;
  }
}
