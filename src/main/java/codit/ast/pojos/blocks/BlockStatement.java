package codit.ast.pojos.blocks;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Deprecated
public abstract class BlockStatement extends AstNode {
  public BlockStatement(Range range, AstNode parent) {
    super(range, parent);
  }

  public BlockStatement(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public BlockStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
