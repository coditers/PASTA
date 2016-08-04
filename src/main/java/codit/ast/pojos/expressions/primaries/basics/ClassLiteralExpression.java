package codit.ast.pojos.expressions.primaries.basics;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Deprecated
public abstract class ClassLiteralExpression extends BasicExpression {
  public ClassLiteralExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public ClassLiteralExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ClassLiteralExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
