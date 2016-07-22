package codit.ast.pojos.literals.longs;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class HexLongLiteral extends LongLiteral {

  public HexLongLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public HexLongLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public HexLongLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
