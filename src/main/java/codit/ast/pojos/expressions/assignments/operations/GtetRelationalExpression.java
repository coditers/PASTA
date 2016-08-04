package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class GtetRelationalExpression extends RelationalExpression {
  private final RelationalExpression relationalExpression;
  private final ShiftExpression shiftExpression;

  public GtetRelationalExpression(Range range, AstNode parent, RelationalExpression relationalExpression, ShiftExpression shiftExpression) {
    super(range, parent);
    this.relationalExpression = relationalExpression;
    this.shiftExpression = shiftExpression;
  }

  public GtetRelationalExpression(Position start, Position end, AstNode parent, RelationalExpression relationalExpression, ShiftExpression shiftExpression) {
    super(start, end, parent);
    this.relationalExpression = relationalExpression;
    this.shiftExpression = shiftExpression;
  }

  public GtetRelationalExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, RelationalExpression relationalExpression, ShiftExpression shiftExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.relationalExpression = relationalExpression;
    this.shiftExpression = shiftExpression;
  }
}
