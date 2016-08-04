package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.StatementExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PostDecrementExpression extends PostfixExpression implements StatementExpression {
  private final PostfixExpression postfixExpression;

  public PostDecrementExpression(Range range, AstNode parent, PostfixExpression postfixExpression) {
    super(range, parent);
    this.postfixExpression = postfixExpression;
  }

  public PostDecrementExpression(Position start, Position end, AstNode parent, PostfixExpression postfixExpression) {
    super(start, end, parent);
    this.postfixExpression = postfixExpression;
  }

  public PostDecrementExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, PostfixExpression postfixExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.postfixExpression = postfixExpression;
  }
}
