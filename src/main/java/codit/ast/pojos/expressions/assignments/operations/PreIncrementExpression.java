package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.StatementExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PreIncrementExpression extends UnaryExpression implements StatementExpression {

  private final UnaryExpression unaryExpression;

  public PreIncrementExpression(Range range, AstNode parent, UnaryExpression unaryExpression) {
    super(range, parent);
    this.unaryExpression = unaryExpression;
  }

  public PreIncrementExpression(Position start, Position end, AstNode parent, UnaryExpression unaryExpression) {
    super(start, end, parent);
    this.unaryExpression = unaryExpression;
  }

  public PreIncrementExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, UnaryExpression unaryExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unaryExpression = unaryExpression;
  }
}
