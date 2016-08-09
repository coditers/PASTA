package codit.ast.pojos.types;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class Type extends AstNode {

  public Type(Range range, AstNode parent) {
    super(range, parent);
  }

  public Type(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public Type(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
