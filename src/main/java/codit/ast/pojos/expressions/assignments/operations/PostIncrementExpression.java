package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.StatementExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PostIncrementExpression extends PostfixExpression implements StatementExpression {
  private final PostfixExpression postfixExpression;

  public PostIncrementExpression(Range range, AstNode parent, PostfixExpression postfixExpression) {
    super(range, parent);
    this.postfixExpression = postfixExpression;
  }

  public PostIncrementExpression(Position start, Position end, AstNode parent, PostfixExpression postfixExpression) {
    super(start, end, parent);
    this.postfixExpression = postfixExpression;
  }

  public PostIncrementExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, PostfixExpression postfixExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.postfixExpression = postfixExpression;
  }
}
