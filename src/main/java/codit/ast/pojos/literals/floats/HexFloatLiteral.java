package codit.ast.pojos.literals.floats;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class HexFloatLiteral extends FloatLiteral {

  public HexFloatLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
  }

  public HexFloatLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
  }

  public HexFloatLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
  }
}
