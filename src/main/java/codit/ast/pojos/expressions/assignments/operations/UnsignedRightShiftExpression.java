package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnsignedRightShiftExpression extends ShiftExpression {
  private final ShiftExpression shiftExpression;
  private final AdditiveExpression additiveExpression;

  public UnsignedRightShiftExpression(Range range, AstNode parent, ShiftExpression shiftExpression, AdditiveExpression additiveExpression) {
    super(range, parent);
    this.shiftExpression = shiftExpression;
    this.additiveExpression = additiveExpression;
  }

  public UnsignedRightShiftExpression(Position start, Position end, AstNode parent, ShiftExpression shiftExpression, AdditiveExpression additiveExpression) {
    super(start, end, parent);
    this.shiftExpression = shiftExpression;
    this.additiveExpression = additiveExpression;
  }

  public UnsignedRightShiftExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, ShiftExpression shiftExpression, AdditiveExpression additiveExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.shiftExpression = shiftExpression;
    this.additiveExpression = additiveExpression;
  }
}
