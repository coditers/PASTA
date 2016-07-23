package codit.ast.pojos.annotations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class Annotation extends AstNode {

  public Annotation(Range range) {
    super(range);
  }

  public Annotation(Position start, Position end) {
    super(start, end);
  }

  public Annotation(int startLine, int startCol, int endLine, int endCol) {
    super(startLine, startCol, endLine, endCol);
  }
}
