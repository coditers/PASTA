package codit.ast.pojos.literals;

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

  public String getRawString() {
    return rawString;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;

    if (!(o instanceof Literal)) { // For comparing subclass with superclass
      return false;
    }

    Literal literal = (Literal) o;

    return rawString.equals(literal.rawString);

  }

  @Override
  public int hashCode() {
    return rawString.hashCode();
  }
}
