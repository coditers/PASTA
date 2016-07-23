package codit.ast.pojos.names;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PackageOrTypeName extends Name {

  private final PackageOrTypeName prev;

  public PackageOrTypeName(Range range,
                           String identifier,
                           PackageOrTypeName prev) {
    super(range, identifier);
    this.prev = prev;
  }

  public PackageOrTypeName(Position start, Position end,
                           String identifier,
                           PackageOrTypeName prev) {
    super(start, end, identifier);
    this.prev = prev;
  }

  public PackageOrTypeName(int startLine, int startCol, int endLine, int endCol,
                           String identifier,
                           PackageOrTypeName prev) {
    super(startLine, startCol, endLine, endCol, identifier);
    this.prev = prev;
  }
}
