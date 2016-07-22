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
  public Literal(Range range, String rawString) {
    super(range);
    this.rawString = rawString;
  }

  public Literal(Position start, Position end, String rawString) {
    super(start, end);
    this.rawString = rawString;
  }

  public Literal(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol);
    this.rawString = rawString;
  }

  public String getRawString() {
    return rawString;
  }
}
