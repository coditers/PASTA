package codit.ast.pojos.names;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

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

  @JsonProperty(value="prev")
  public PackageOrTypeName getPrev() {
    return prev;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TypeName)) return false;
    if (!super.equals(o)) return false;

    TypeName typeName = (TypeName) o;

    return prev != null ? prev.equals(typeName.prev) : typeName.prev == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (prev != null ? prev.hashCode() : 0);
    return result;
  }
}
