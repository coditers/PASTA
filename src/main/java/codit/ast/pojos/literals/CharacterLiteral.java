package codit.ast.pojos.literals;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class CharacterLiteral extends Literal {

  // private final char val;

  public CharacterLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
    // this.val = parseChar(rawString);
  }

  public CharacterLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
    // this.val = parseChar(rawString);
  }

  public CharacterLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
    // this.val = parseChar(rawString);
  }


  // public char parseChar(String rawString) { }

  // public char getValue() {}


}