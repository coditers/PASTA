package codit.ast.pojos.statements.withoutsubstatement.tries;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.blocks.Block;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class CatchClause extends AstNode {

  private final CatchFormalParameter catchFormalParameter;
  private final Block block;

  public CatchClause(Range range, AstNode parent,
                     CatchFormalParameter catchFormalParameter,
                     Block block) {
    super(range, parent);
    this.catchFormalParameter = catchFormalParameter;
    this.block = block;
  }

  public CatchClause(Position start, Position end, AstNode parent,
                     CatchFormalParameter catchFormalParameter,
                     Block block) {
    super(start, end, parent);
    this.catchFormalParameter = catchFormalParameter;
    this.block = block;
  }

  public CatchClause(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                     CatchFormalParameter catchFormalParameter,
                     Block block) {
    super(startLine, startCol, endLine, endCol, parent);
    this.catchFormalParameter = catchFormalParameter;
    this.block = block;
  }

  @JsonProperty("CatchFormalParameter")
  public CatchFormalParameter getCatchFormalParameter() {
    return catchFormalParameter;
  }

  @JsonProperty("Block")
  public Block getBlock() {
    return block;
  }
}
