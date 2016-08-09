package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.StatementExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PreDecrementExpression extends UnaryExpression implements StatementExpression {

  private final UnaryExpression unaryExpression;

  public PreDecrementExpression(Range range, AstNode parent, UnaryExpression unaryExpression) {
    super(range, parent);
    this.unaryExpression = unaryExpression;
  }

  public PreDecrementExpression(Position start, Position end, AstNode parent, UnaryExpression unaryExpression) {
    super(start, end, parent);
    this.unaryExpression = unaryExpression;
  }

  public PreDecrementExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, UnaryExpression unaryExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unaryExpression = unaryExpression;
  }
}
