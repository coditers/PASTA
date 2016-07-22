package codit.ast.pojos.literals.integers;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class DecimalIntegerLiteral extends IntegerLiteral {

  public DecimalIntegerLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public DecimalIntegerLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public DecimalIntegerLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
