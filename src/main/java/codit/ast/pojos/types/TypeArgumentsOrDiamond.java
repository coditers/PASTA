package codit.ast.pojos.types;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class TypeArgumentsOrDiamond extends AstNode {

  public TypeArgumentsOrDiamond(Range range, AstNode parent) {
    super(range, parent);
  }

  public TypeArgumentsOrDiamond(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public TypeArgumentsOrDiamond(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
