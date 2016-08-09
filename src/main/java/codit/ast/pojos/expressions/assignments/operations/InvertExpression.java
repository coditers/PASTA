package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InvertExpression extends UnaryExpressionNotPlusMinus {

  private final UnaryExpression unaryExpression;

  public InvertExpression(Range range, AstNode parent, UnaryExpression unaryExpression) {
    super(range, parent);
    this.unaryExpression = unaryExpression;
  }

  public InvertExpression(Position start, Position end, AstNode parent, UnaryExpression unaryExpression) {
    super(start, end, parent);
    this.unaryExpression = unaryExpression;
  }

  public InvertExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, UnaryExpression unaryExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unaryExpression = unaryExpression;
  }
}
