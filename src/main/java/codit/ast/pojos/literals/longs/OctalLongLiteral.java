package codit.ast.pojos.literals.longs;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class OctalLongLiteral extends LongLiteral {

  public OctalLongLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public OctalLongLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public OctalLongLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
