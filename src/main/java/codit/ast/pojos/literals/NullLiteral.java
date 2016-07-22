package codit.ast.pojos.literals;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class NullLiteral extends Literal {

  public NullLiteral(Range range, String rawString) {
    super(range, rawString);
  }

  public NullLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
  }

  public NullLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
  }
}
