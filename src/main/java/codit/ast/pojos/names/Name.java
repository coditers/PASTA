package codit.ast.pojos.names;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Name extends AstNode {

  private final String identifier;

  public Name(Range range, AstNode parent,
              String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public Name(Position start, Position end, AstNode parent,
              String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public Name(int startLine, int startCol, int endLine, int endCol, AstNode parent,
              String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }

  @JsonProperty(value="identifier")
  public String getIdentifier() {
    return identifier;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Name)) return false;
    if (!super.equals(o)) return false;

    Name name = (Name) o;

    return identifier != null ? identifier.equals(name.identifier) : name.identifier == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
    return result;
  }
}
