package codit.ast.pojos.expressions.primaries.methodinvocation;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.StatementExpression;
import codit.ast.pojos.expressions.primaries.PrimaryExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class MethodInvocation extends PrimaryExpression implements StatementExpression {
  public MethodInvocation(Range range, AstNode parent) {
    super(range, parent);
  }

  public MethodInvocation(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public MethodInvocation(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
