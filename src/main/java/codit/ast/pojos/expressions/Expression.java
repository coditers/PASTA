package codit.ast.pojos.expressions;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class Expression extends AstNode {
  public Expression(Range range, AstNode parent) {
    super(range, parent);
  }

  public Expression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public Expression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
