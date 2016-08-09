package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LtRelationalExpression extends RelationalExpression {

  private final RelationalExpression relationalExpression;
  private final ShiftExpression shiftExpression;

  public LtRelationalExpression(Range range, AstNode parent, RelationalExpression relationalExpression, ShiftExpression shiftExpression) {
    super(range, parent);
    this.relationalExpression = relationalExpression;
    this.shiftExpression = shiftExpression;
  }

  public LtRelationalExpression(Position start, Position end, AstNode parent, RelationalExpression relationalExpression, ShiftExpression shiftExpression) {
    super(start, end, parent);
    this.relationalExpression = relationalExpression;
    this.shiftExpression = shiftExpression;
  }

  public LtRelationalExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, RelationalExpression relationalExpression, ShiftExpression shiftExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.relationalExpression = relationalExpression;
    this.shiftExpression = shiftExpression;
  }
}
