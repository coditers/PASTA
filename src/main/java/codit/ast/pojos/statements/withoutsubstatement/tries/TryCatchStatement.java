package codit.ast.pojos.statements.withoutsubstatement.tries;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.blocks.Block;
import codit.ast.pojos.statements.withoutsubstatement.TryStatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TryCatchStatement extends TryStatement {

  private final Block tryBlock;

  private final List<CatchClause> catchClauseList;

  public TryCatchStatement(Range range, AstNode parent,
                           Block tryBlock,
                           List<CatchClause> catchClauseList) {
    super(range, parent);
    this.tryBlock = tryBlock;
    this.catchClauseList = catchClauseList;
  }

  public TryCatchStatement(Position start, Position end, AstNode parent,
                           Block tryBlock,
                           List<CatchClause> catchClauseList) {
    super(start, end, parent);
    this.tryBlock = tryBlock;
    this.catchClauseList = catchClauseList;
  }

  public TryCatchStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                           Block tryBlock,
                           List<CatchClause> catchClauseList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.tryBlock = tryBlock;
    this.catchClauseList = catchClauseList;
  }
}
