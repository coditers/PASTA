package codit.ast.pojos.names;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeName extends Name {

  private final PackageOrTypeName prev;

  public TypeName(Range range, AstNode parent,
                  String identifier,
                  PackageOrTypeName prev) {
    super(range, parent, identifier);
    this.prev = prev;
  }

  public TypeName(Position start, Position end, AstNode parent,
                  String identifier,
                  PackageOrTypeName prev) {
    super(start, end, parent, identifier);
    this.prev = prev;
  }

  public TypeName(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                  String identifier,
                  PackageOrTypeName prev) {
    super(startLine, startCol, endLine, endCol, parent, identifier);
    this.prev = prev;
  }
}
