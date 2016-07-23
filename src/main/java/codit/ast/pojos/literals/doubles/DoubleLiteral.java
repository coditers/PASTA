package codit.ast.pojos.literals.doubles;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.literals.Literal;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Deprecated
public abstract class DoubleLiteral extends Literal {

  // TODO
  // private final double val;

  public DoubleLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
    // this.val = parseDouble(rawString);
  }

  public DoubleLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
    // this.val = parseDouble(rawString);
  }

  public DoubleLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
    // this.val = parseDouble(rawString);
  }


  // TODO
  // public abstract double parseDouble(String rawString);
}
