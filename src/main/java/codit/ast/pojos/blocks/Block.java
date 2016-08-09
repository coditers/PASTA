package codit.ast.pojos.blocks;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.lambdas.LambdaBody;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Block extends AstNode implements LambdaBody {

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
