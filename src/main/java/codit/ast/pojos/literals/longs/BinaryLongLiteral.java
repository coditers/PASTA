package codit.ast.pojos.literals.longs;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Deprecated
public class BinaryLongLiteral extends LongLiteral {

  public BinaryLongLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public BinaryLongLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public BinaryLongLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
