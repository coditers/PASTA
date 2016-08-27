package codit.ast.pojos.statements.withoutsubstatement.tries;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
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

  @JsonProperty("TryBlock")
  public Block getTryBlock() {
    return tryBlock;
  }

  @JsonProperty("CatchClauseList")
  public List<CatchClause> getCatchClauseList() {
    return catchClauseList;
  }

  @JsonProperty("FinallyBlock")
  public Block getFinallyBlock() {
    return finallyBlock;
  }
}
