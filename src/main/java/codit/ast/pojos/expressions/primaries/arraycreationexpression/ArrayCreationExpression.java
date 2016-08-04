package codit.ast.pojos.expressions.primaries.arraycreationexpression;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ArrayCreationExpression extends AstNode {

  public ArrayCreationExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public ArrayCreationExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ArrayCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
