package codit.ast.pojos.blocks;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Block extends AstNode {

  private final BlockStatements blockStatements;

  public Block(Range range, AstNode parent,
               BlockStatements blockStatements) {
    super(range, parent);
    this.blockStatements = blockStatements;
  }

  public Block(Position start, Position end, AstNode parent,
               BlockStatements blockStatements) {
    super(start, end, parent);
    this.blockStatements = blockStatements;
  }

  public Block(int startLine, int startCol, int endLine, int endCol, AstNode parent,
               BlockStatements blockStatements) {
    super(startLine, startCol, endLine, endCol, parent);
    this.blockStatements = blockStatements;
  }
}
