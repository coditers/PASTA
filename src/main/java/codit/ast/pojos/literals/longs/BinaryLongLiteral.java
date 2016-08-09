package codit.ast.pojos.literals.longs;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BinaryLongLiteral extends LongLiteral {
  public BinaryLongLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
  }

  public BinaryLongLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
  }

  public BinaryLongLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
  }
}
