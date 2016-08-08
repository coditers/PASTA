package codit.ast.pojos.literals;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class Literal extends AstNode {

  /** Field variable */
  private final String rawString;

  /** Constructors */
  public Literal(Range range, AstNode parent,
                 String rawString) {
    super(range, parent);
    this.rawString = rawString;
  }

  public Literal(Position start, Position end, AstNode parent,
                 String rawString) {
    super(start, end, parent);
    this.rawString = rawString;
  }

  public Literal(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                 String rawString) {
    super(startLine, startCol, endLine, endCol, parent);
    this.rawString = rawString;
  }

  @JsonProperty(value="str")
  public String getRawString() {
    return rawString;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Literal)) return false;

    Literal literal = (Literal) o;

    return rawString != null ? rawString.equals(literal.rawString) : literal.rawString == null;

  }

  @Override
  public int hashCode() {
    return rawString != null ? rawString.hashCode() : 0;
  }
}
