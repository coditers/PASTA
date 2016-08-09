package codit.ast.pojos.literals.integers;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class DecimalIntegerLiteral extends IntegerLiteral {
  public DecimalIntegerLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
  }

  public DecimalIntegerLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
  }

  public DecimalIntegerLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
  }
}
