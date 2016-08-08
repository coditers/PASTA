package codit.ast.pojos.literals.doubles;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class DecimalDoubleLiteral extends DoubleLiteral {

  public DecimalDoubleLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
  }

  public DecimalDoubleLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
  }

  public DecimalDoubleLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
  }
}
