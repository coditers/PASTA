package codit.ast.pojos.literals.integers;

import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.literals.Literal;

/**
 * Subclasses
 * <ul>
 *   <li>{@code DecimalIntegerLiteral}</li>
 *   <li>{@code HexIntegerLiteral}</li>
 *   <li>{@code OctalIntegerLiteral}</li>
 *   <li>{@code BinaryIntegerLiteral}</li>
 * </ul>
 *
 *
 * @author Jisung Lim ( iejisung@gmail.com )
 * @since July, 2016.
 */
public abstract class IntegerLiteral extends Literal {


  private final boolean isLong;
  // TODO - Additional Field Variable
  // private final int value;

  /** Constructors */
  public IntegerLiteral(Range range, String rawString) {
    super(range, rawString);
    this.isLong = isLong(rawString);
    // this.value = parseInt(rawString);
  }

  public IntegerLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
    this.isLong = isLong(rawString);
    // this.value = parseInt(rawString);
  }

  public IntegerLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
    this.isLong = isLong(rawString);
    // this.value = parseInt(rawString);
  }

  public boolean isLong(String rawString) {
    return rawString.endsWith("L");
  }

  public boolean isLong() {
    return isLong();
  }

  // TODO - Semantic step
  // public abstract int parseInt(String rawString);

  // TODO - Getter for field variable
  // public int getValue() {}


}
