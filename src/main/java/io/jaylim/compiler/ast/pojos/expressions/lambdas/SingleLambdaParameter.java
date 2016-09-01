package io.jaylim.compiler.ast.pojos.expressions.lambdas;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SingleLambdaParameter extends LambdaParameters {

  private final String identifier;

  public SingleLambdaParameter(Range range, AstNode parent,
                               String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public SingleLambdaParameter(Position start, Position end, AstNode parent,
                               String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public SingleLambdaParameter(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                               String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }
}
