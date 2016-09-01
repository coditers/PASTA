package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ImplConditionalOrExpression extends ConditionalOrExpression {
  private final ConditionalOrExpression conditionalOrExpression;
  private final ConditionalAndExpression conditionalAndExpression;

  public ImplConditionalOrExpression(Range range, AstNode parent,
                                     ConditionalOrExpression conditionalOrExpression,
                                     ConditionalAndExpression conditionalAndExpression) {
    super(range, parent);
    this.conditionalOrExpression = conditionalOrExpression;
    this.conditionalAndExpression = conditionalAndExpression;
  }

  public ImplConditionalOrExpression(Position start, Position end, AstNode parent,
                                     ConditionalOrExpression conditionalOrExpression,
                                     ConditionalAndExpression conditionalAndExpression) {
    super(start, end, parent);
    this.conditionalOrExpression = conditionalOrExpression;
    this.conditionalAndExpression = conditionalAndExpression;
  }

  public ImplConditionalOrExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                     ConditionalOrExpression conditionalOrExpression,
                                     ConditionalAndExpression conditionalAndExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.conditionalOrExpression = conditionalOrExpression;
    this.conditionalAndExpression = conditionalAndExpression;
  }

  @JsonProperty("ConditionalOrExpression")
  public ConditionalOrExpression getConditionalOrExpression() {
    return conditionalOrExpression;
  }

  @JsonProperty("ConditionalAndExpression")
  public ConditionalAndExpression getConditionalAndExpression() {
    return conditionalAndExpression;
  }
}
