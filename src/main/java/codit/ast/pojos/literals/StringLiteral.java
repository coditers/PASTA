package codit.ast.pojos.literals;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class StringLiteral extends Literal {

  // private final String val;

  public StringLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
    // this.val = parseString(rawString);
  }

  public StringLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
    // this.val = parseString(rawString);
  }

  public StringLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
    // this.val = parseString(rawString);
  }


  // public String parseString(String rawString) {}

  // public String getValue() {}
}
