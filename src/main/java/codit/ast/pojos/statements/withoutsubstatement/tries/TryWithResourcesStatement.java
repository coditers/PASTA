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
public class TryWithResourcesStatement extends TryStatement {


  private final List<Resource> resourceSpecification;

  private final Block tryBlock;

  private final List<CatchClause> catchClauseList;

  private final Block finallyBlock;

  public TryWithResourcesStatement(Range range, AstNode parent,
                                   List<Resource> resourceSpecification,
                                   Block tryBlock,
                                   List<CatchClause> catchClauseList,
                                   Block finallyBlock) {
    super(range, parent);
    this.resourceSpecification = resourceSpecification;
    this.tryBlock = tryBlock;
    this.catchClauseList = catchClauseList;
    this.finallyBlock = finallyBlock;
  }

  public TryWithResourcesStatement(Position start, Position end, AstNode parent,
                                   List<Resource> resourceSpecification,
                                   Block tryBlock,
                                   List<CatchClause> catchClauseList,
                                   Block finallyBlock) {
    super(start, end, parent);
    this.resourceSpecification = resourceSpecification;
    this.tryBlock = tryBlock;
    this.catchClauseList = catchClauseList;
    this.finallyBlock = finallyBlock;
  }

  public TryWithResourcesStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   List<Resource> resourceSpecification,
                                   Block tryBlock,
                                   List<CatchClause> catchClauseList,
                                   Block finallyBlock) {
    super(startLine, startCol, endLine, endCol, parent);
    this.resourceSpecification = resourceSpecification;
    this.tryBlock = tryBlock;
    this.catchClauseList = catchClauseList;
    this.finallyBlock = finallyBlock;
  }
}
