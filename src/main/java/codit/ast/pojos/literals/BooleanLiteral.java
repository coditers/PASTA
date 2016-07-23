package codit.ast.pojos.literals;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BooleanLiteral extends Literal {

  // TODO -
  // private final boolean isTrue;

  public BooleanLiteral(Range range,
                        AstNode parent, String rawString) {
    super(range, parent, rawString);
    // this.isTrue = isTrue(rawString);
  }

  public BooleanLiteral(Position start, Position end,
                        AstNode parent, String rawString) {
    super(start, end, parent, rawString);
    // this.isTrue = isTrue(rawString);
  }

  public BooleanLiteral(int startLine, int startCol, int endLine, int endCol,
                        AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
    // this.isTrue = isTrue(rawString);
  }

  // TODO -
  // public boolean isTrue(String rawString) {}

  // TODO -
  // public boolean isTrue() {}
}
