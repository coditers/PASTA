package codit.ast.pojos.literals.integers;

import codit.ast.AstNode;
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

  // TODO - Additional Field Variable
  // private final boolean isLong;
  // private final int value;

  /** Constructors */
  public IntegerLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
    // this.isLong = isLong(rawString);
    // this.value = parseInt(rawString);
  }

  public IntegerLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
    // this.isLong = isLong(rawString);
    // this.value = parseInt(rawString);
  }

  public IntegerLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
    // this.isLong = isLong(rawString);
    // this.value = parseInt(rawString);
  }

  // TODO - Semantic step
  // public boolean isLong(String rs) { return rs.endsWith("L") || rs.endsWith("l"); }
  // public abstract int parseInt(String rawString);

  // TODO - Getter for field variable
  // public boolean isLong() { return isLong(); }
  // public int getValue() { return value;}

}
