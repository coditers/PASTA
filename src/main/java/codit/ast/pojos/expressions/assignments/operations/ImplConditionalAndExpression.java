package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ImplConditionalAndExpression extends ConditionalAndExpression {

  private final ConditionalAndExpression conditionalAndExpression;
  private final InclusiveOrExpression inclusiveOrExpression;

  public ImplConditionalAndExpression(Range range, AstNode parent,
                                      ConditionalAndExpression conditionalAndExpression,
                                      InclusiveOrExpression inclusiveOrExpression) {
    super(range, parent);
    this.conditionalAndExpression = conditionalAndExpression;
    this.inclusiveOrExpression = inclusiveOrExpression;
  }

  public ImplConditionalAndExpression(Position start, Position end, AstNode parent,
                                      ConditionalAndExpression conditionalAndExpression,
                                      InclusiveOrExpression inclusiveOrExpression) {
    super(start, end, parent);
    this.conditionalAndExpression = conditionalAndExpression;
    this.inclusiveOrExpression = inclusiveOrExpression;
  }

  public ImplConditionalAndExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                      ConditionalAndExpression conditionalAndExpression,
                                      InclusiveOrExpression inclusiveOrExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.conditionalAndExpression = conditionalAndExpression;
    this.inclusiveOrExpression = inclusiveOrExpression;
  }
}
