package io.jaylim.compiler.ast.pojos.names;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PackageOrTypeName extends Name {

  private final PackageOrTypeName prev;

  public PackageOrTypeName(Range range, AstNode parent,
                           String identifier,
                           PackageOrTypeName prev) {
    super(range, parent, identifier);
    this.prev = prev;
  }

  public PackageOrTypeName(Position start, Position end, AstNode parent,
                           String identifier,
                           PackageOrTypeName prev) {
    super(start, end, parent, identifier);
    this.prev = prev;
  }

  public PackageOrTypeName(int startLine, int startCol, int endLine, int endCol, AstNode parent,
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
    if (!(o instanceof PackageOrTypeName)) return false;
    if (!super.equals(o)) return false;

    PackageOrTypeName that = (PackageOrTypeName) o;

    return prev != null ? prev.equals(that.prev) : that.prev == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (prev != null ? prev.hashCode() : 0);
    return result;
  }
}
