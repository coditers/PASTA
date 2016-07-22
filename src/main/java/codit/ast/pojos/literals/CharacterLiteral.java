package codit.ast.pojos.literals;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class CharacterLiteral extends Literal {

  // private final char val;

  public CharacterLiteral(Range range, String rawString) {
    super(range, rawString);
    // this.val = parseChar(rawString);
  }

  public CharacterLiteral(Position start, Position end, String rawString) {
    super(start, end, rawString);
    // this.val = parseChar(rawString);
  }

  public CharacterLiteral(int startLine, int startCol, int endLine, int endCol, String rawString) {
    super(startLine, startCol, endLine, endCol, rawString);
    // this.val = parseChar(rawString);
  }

  // public char parseChar(String rawString) { }

  // public char getValue() {}

}