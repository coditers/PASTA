package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PositiveAdditiveExpression extends AdditiveExpression {

  private final AdditiveExpression additiveExpression;
  private final MultiplicativeExpression multiplicativeExpression;

  public PositiveAdditiveExpression(Range range, AstNode parent, AdditiveExpression additiveExpression, MultiplicativeExpression multiplicativeExpression) {
    super(range, parent);
    this.additiveExpression = additiveExpression;
    this.multiplicativeExpression = multiplicativeExpression;
  }

  public PositiveAdditiveExpression(Position start, Position end, AstNode parent, AdditiveExpression additiveExpression, MultiplicativeExpression multiplicativeExpression) {
    super(start, end, parent);
    this.additiveExpression = additiveExpression;
    this.multiplicativeExpression = multiplicativeExpression;
  }

  public PositiveAdditiveExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, AdditiveExpression additiveExpression, MultiplicativeExpression multiplicativeExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.additiveExpression = additiveExpression;
    this.multiplicativeExpression = multiplicativeExpression;
  }
}
