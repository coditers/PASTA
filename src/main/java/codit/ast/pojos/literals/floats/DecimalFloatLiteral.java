package codit.ast.pojos.literals.floats;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class DecimalFloatLiteral extends FloatLiteral {

  public DecimalFloatLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public DecimalFloatLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public DecimalFloatLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
