package codit.ast.pojos.literals.floats;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class HexFloatLiteral extends FloatLiteral {

  public HexFloatLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public HexFloatLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public HexFloatLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
