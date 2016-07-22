package codit.ast.pojos.literals;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class StringLiteral extends Literal {

  // private final String val;

  public StringLiteral(Range range, String rawString) {
    super(range, rawString);
    // this.val = parseString(rawString);
  }

  public StringLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
    // this.val = parseString(rawString);
  }

  public StringLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
    // this.val = parseString(rawString);
  }


  // public String parseString(String rawString) {}

  // public String getValue() {}
}
