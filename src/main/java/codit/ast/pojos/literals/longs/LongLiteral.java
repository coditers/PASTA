package codit.ast.pojos.literals.longs;

import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.literals.Literal;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class LongLiteral extends Literal {

  // TODO -Additional Field Variable
  // private final long value;

  public LongLiteral(Range range, String rawString) {
    super(range, rawString);
    // this.value = parseLong(rawString);
  }

  public LongLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
    // this.value = parseLong(rawString);
  }

  public LongLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
    // this.value = parseLong(rawString);
  }

  // TODO - Semantic step
  // public abstract long parseLong(String rawString);

  // TODO - Getter for field variable
  // public long getValue(){}
}
