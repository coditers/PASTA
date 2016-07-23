package codit.ast.pojos.names;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class AmbiguousName extends Name {

  private final AmbiguousName prev;

  public AmbiguousName(Range range,
                       String identifier,
                       AmbiguousName prev) {
    super(range, identifier);
    this.prev = prev;
  }

  public AmbiguousName(Position start, Position end,
                       String identifier,
                       AmbiguousName prev) {
    super(start, end, identifier);
    this.prev = prev;
  }

  public AmbiguousName(int startLine, int startCol, int endLine, int endCol,
                       String identifier,
                       AmbiguousName prev) {
    super(startLine, startCol, endLine, endCol, identifier);
    this.prev = prev;
  }
}
