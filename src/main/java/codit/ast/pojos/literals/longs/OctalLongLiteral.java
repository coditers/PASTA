package codit.ast.pojos.literals.longs;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Deprecated
public class OctalLongLiteral extends LongLiteral {
  public OctalLongLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
  }

  public OctalLongLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
  }

  public OctalLongLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
  }
}
