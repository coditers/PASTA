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
public class TryCatchFinallyStatement extends TryStatement {

  private final Block tryBlock;

  private final List<CatchClause> catchClauseList;

  private final Block finallyBlock;

  public TryCatchFinallyStatement(Range range, AstNode parent,
                                  Block tryBlock,
                                  List<CatchClause> catchClauseList,
                                  Block finallyBlock) {
    super(range, parent);
    this.tryBlock = tryBlock;
    this.catchClauseList = catchClauseList;
    this.finallyBlock = finallyBlock;
  }

  public TryCatchFinallyStatement(Position start, Position end, AstNode parent,
                                  Block tryBlock,
                                  List<CatchClause> catchClauseList,
                                  Block finallyBlock) {
    super(start, end, parent);
    this.tryBlock = tryBlock;
    this.catchClauseList = catchClauseList;
    this.finallyBlock = finallyBlock;
  }

  public TryCatchFinallyStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                  Block tryBlock,
                                  List<CatchClause> catchClauseList,
                                  Block finallyBlock) {
    super(startLine, startCol, endLine, endCol, parent);
    this.tryBlock = tryBlock;
    this.catchClauseList = catchClauseList;
    this.finallyBlock = finallyBlock;
  }
}
