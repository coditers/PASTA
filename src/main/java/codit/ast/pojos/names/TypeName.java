package codit.ast.pojos.names;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeName extends Name {

  private final PackageOrTypeName prev;

  public TypeName(Range range,
                  String identifier,
                  PackageOrTypeName prev) {
    super(range, identifier);
    this.prev = prev;
  }

  public TypeName(Position start, Position end,
                  String identifier,
                  PackageOrTypeName prev) {
    super(start, end, identifier);
    this.prev = prev;
  }

  public TypeName(int startLine, int startCol, int endLine, int endCol,
                  String identifier,
                  PackageOrTypeName prev) {
    super(startLine, startCol, endLine, endCol, identifier);
    this.prev = prev;
  }
}
