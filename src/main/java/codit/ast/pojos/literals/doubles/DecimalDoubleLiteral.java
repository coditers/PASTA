package codit.ast.pojos.literals.doubles;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Deprecated
public class DecimalDoubleLiteral extends DoubleLiteral {
  public DecimalDoubleLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public DecimalDoubleLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public DecimalDoubleLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
