package codit.ast.pojos.names;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class AmbiguousName extends Name {

  private final AmbiguousName prev;

  public AmbiguousName(Range range, AstNode parent,
                       String identifier,
                       AmbiguousName prev) {
    super(range, parent, identifier);
    this.prev = prev;
  }

  public AmbiguousName(Position start, Position end, AstNode parent,
                       String identifier,
                       AmbiguousName prev) {
    super(start, end, parent, identifier);
    this.prev = prev;
  }

  public AmbiguousName(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                       String identifier,
                       AmbiguousName prev) {
    super(startLine, startCol, endLine, endCol, parent, identifier);
    this.prev = prev;
  }
}
