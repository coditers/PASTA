package codit.ast.pojos.literals.integers;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BinaryIntegerLiteral extends IntegerLiteral {

  public BinaryIntegerLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public BinaryIntegerLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public BinaryIntegerLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
