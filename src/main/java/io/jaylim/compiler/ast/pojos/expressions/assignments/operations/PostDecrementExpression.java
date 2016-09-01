package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.StatementExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PostDecrementExpression extends PostfixExpression implements StatementExpression {
  private final PostfixExpression postfixExpression;

  public PostDecrementExpression(Range range, AstNode parent, PostfixExpression postfixExpression) {
    super(range, parent);
    this.postfixExpression = postfixExpression;
  }

  public PostDecrementExpression(Position start, Position end, AstNode parent, PostfixExpression postfixExpression) {
    super(start, end, parent);
    this.postfixExpression = postfixExpression;
  }

  public PostDecrementExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, PostfixExpression postfixExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.postfixExpression = postfixExpression;
  }

  @JsonProperty("PostfixExpression")
  public PostfixExpression getPostfixExpression() {
    return postfixExpression;
  }
}
