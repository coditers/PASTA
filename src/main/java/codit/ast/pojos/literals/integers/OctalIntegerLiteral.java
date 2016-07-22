package codit.ast.pojos.literals.integers;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class OctalIntegerLiteral extends IntegerLiteral {

  public OctalIntegerLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public OctalIntegerLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public OctalIntegerLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
