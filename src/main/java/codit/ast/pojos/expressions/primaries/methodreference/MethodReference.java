package codit.ast.pojos.expressions.primaries.methodreference;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.PrimaryExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class MethodReference extends PrimaryExpression {
  public MethodReference(Range range, AstNode parent) {
    super(range, parent);
  }

  public MethodReference(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public MethodReference(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}