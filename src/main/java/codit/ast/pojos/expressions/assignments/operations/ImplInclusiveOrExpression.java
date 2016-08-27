package codit.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ImplInclusiveOrExpression extends InclusiveOrExpression {

  private final InclusiveOrExpression inclusiveOrExpression;
  private final ExclusiveOrExpression exclusiveOrExpression;

  public ImplInclusiveOrExpression(Range range, AstNode parent,
                                   InclusiveOrExpression inclusiveOrExpression,
                                   ExclusiveOrExpression exclusiveOrExpression) {
    super(range, parent);
    this.inclusiveOrExpression = inclusiveOrExpression;
    this.exclusiveOrExpression = exclusiveOrExpression;
  }

  public ImplInclusiveOrExpression(Position start, Position end, AstNode parent,
                                   InclusiveOrExpression inclusiveOrExpression,
                                   ExclusiveOrExpression exclusiveOrExpression) {
    super(start, end, parent);
    this.inclusiveOrExpression = inclusiveOrExpression;
    this.exclusiveOrExpression = exclusiveOrExpression;
  }

  public ImplInclusiveOrExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   InclusiveOrExpression inclusiveOrExpression,
                                   ExclusiveOrExpression exclusiveOrExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.inclusiveOrExpression = inclusiveOrExpression;
    this.exclusiveOrExpression = exclusiveOrExpression;
  }

  @JsonProperty("InclusiveOrExpression")
  public InclusiveOrExpression getInclusiveOrExpression() {
    return inclusiveOrExpression;
  }

  @JsonProperty("ExclusiveOrExpression")
  public ExclusiveOrExpression getExclusiveOrExpression() {
    return exclusiveOrExpression;
  }
}
