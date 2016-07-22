package codit.ast.pojos.literals;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BooleanLiteral extends Literal {

  // TODO -
  // private final boolean isTrue;

  public BooleanLiteral(Range range, String rawString) {
    super(range, rawString);
    // this.isTrue = isTrue(rawString);
  }

  public BooleanLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
    // this.isTrue = isTrue(rawString);
  }

  public BooleanLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
    // this.isTrue = isTrue(rawString);
  }

  // TODO -
  // public boolean isTrue(String rawString) {}

  // TODO -
  // public boolean isTrue() {}
}
