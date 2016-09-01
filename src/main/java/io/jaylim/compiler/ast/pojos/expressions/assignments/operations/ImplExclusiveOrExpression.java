package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ImplExclusiveOrExpression extends ExclusiveOrExpression {

  private final ExclusiveOrExpression exclusiveOrExpression;
  private final AndExpression andExpression;

  public ImplExclusiveOrExpression(Range range, AstNode parent,
                                   ExclusiveOrExpression exclusiveOrExpression,
                                   AndExpression andExpression) {
    super(range, parent);
    this.exclusiveOrExpression = exclusiveOrExpression;
    this.andExpression = andExpression;
  }

  public ImplExclusiveOrExpression(Position start, Position end, AstNode parent,
                                   ExclusiveOrExpression exclusiveOrExpression,
                                   AndExpression andExpression) {
    super(start, end, parent);
    this.exclusiveOrExpression = exclusiveOrExpression;
    this.andExpression = andExpression;
  }

  public ImplExclusiveOrExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   ExclusiveOrExpression exclusiveOrExpression,
                                   AndExpression andExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.exclusiveOrExpression = exclusiveOrExpression;
    this.andExpression = andExpression;
  }

  @JsonProperty("ExclusiveOrExpression")
  public ExclusiveOrExpression getExclusiveOrExpression() {
    return exclusiveOrExpression;
  }

  @JsonProperty("AndExpression")
  public AndExpression getAndExpression() {
    return andExpression;
  }
}
