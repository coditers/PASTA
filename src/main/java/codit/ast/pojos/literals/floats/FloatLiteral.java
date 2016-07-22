package codit.ast.pojos.literals.floats;

import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.literals.Literal;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class FloatLiteral extends Literal {

  // TODO - Additional Field Variable
  // private final boolean isDouble;
  // private final float value;

  public FloatLiteral(Range range, String rawString) {
    super(range, rawString);
    // this.isDouble = isDouble(rawString);
    // this.value = parseFloat(rawString);
  }

  public FloatLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
    // this.isDouble = isDouble(rawString);
    // this.value = parseFloat(rawString);
  }

  public FloatLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
    // this.isDouble = isDouble(rawString);
    // this.value = parseFloat(rawString);
  }

  // TODO - Semantic step
//   public boolean isDouble(String rs) { return !rs.endsWith("F") && !rs.endsWith("f"); }
  // public abstract float parseFloat(String rawString);

  // TODO - Getter for field variable
  // public boolean isDouble() { return isDouble; }
  // public int getValue() { return value; }

}
