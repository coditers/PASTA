package codit.ast.pojos.literals.longs;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class DecimalLongLiteral extends LongLiteral {
  public DecimalLongLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
  }

  public DecimalLongLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
  }

  public DecimalLongLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
  }
}
