package codit.ast.pojos.literals.floats;

import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.literals.Literal;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class FloatLiteral extends Literal {

  private final float val;

  public FloatLiteral(Range range, String rawString) {
    super(range, rawString);
    this.val = parseFloat(rawString);
  }

  public FloatLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
    this.val = parseFloat(rawString);
  }

  public FloatLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
    this.val = parseFloat(rawString);
  }

  public abstract float parseFloat(String rawString);
}
