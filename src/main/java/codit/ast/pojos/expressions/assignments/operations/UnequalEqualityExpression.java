package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnequalEqualityExpression extends EqualityExpression {
  private final EqualityExpression equalityExpression;
  private final RelationalExpression relationalExpression;

  public UnequalEqualityExpression(Range range, AstNode parent,
                                   EqualityExpression equalityExpression,
                                   RelationalExpression relationalExpression) {
    super(range, parent);
    this.equalityExpression = equalityExpression;
    this.relationalExpression = relationalExpression;
  }

  public UnequalEqualityExpression(Position start, Position end, AstNode parent,
                                   EqualityExpression equalityExpression,
                                   RelationalExpression relationalExpression) {
    super(start, end, parent);
    this.equalityExpression = equalityExpression;
    this.relationalExpression = relationalExpression;
  }

  public UnequalEqualityExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   EqualityExpression equalityExpression,
                                   RelationalExpression relationalExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.equalityExpression = equalityExpression;
    this.relationalExpression = relationalExpression;
  }
}
