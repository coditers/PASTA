package codit.ast.pojos.types.exceptions;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ExceptionType extends AstNode {
  public ExceptionType(Range range, AstNode parent) {
    super(range, parent);
  }

  public ExceptionType(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ExceptionType(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
