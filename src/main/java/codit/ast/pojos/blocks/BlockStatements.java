package codit.ast.pojos.blocks;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BlockStatements extends AstNode {

  private final List<InBlockStatement> blockStatementList;

  public BlockStatements(Range range, AstNode parent, List<InBlockStatement> blockStatementList) {
    super(range, parent);
    this.blockStatementList = blockStatementList;
  }

  public BlockStatements(Position start, Position end, AstNode parent, List<InBlockStatement> blockStatementList) {
    super(start, end, parent);
    this.blockStatementList = blockStatementList;
  }

  public BlockStatements(int startLine, int startCol, int endLine, int endCol, AstNode parent, List<InBlockStatement> blockStatementList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.blockStatementList = blockStatementList;
  }
}
