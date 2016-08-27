package codit.ast.pojos.statements.withoutsubstatement;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.blocks.Block;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SynchronizedStatement extends AstNode implements StatementWithoutTrailingSubstatement {

  private final Expression expression;
  private final Block block;

  public SynchronizedStatement(Range range, AstNode parent,
                               Expression expression,
                               Block block) {
    super(range, parent);
    this.expression = expression;
    this.block = block;
  }

  public SynchronizedStatement(Position start, Position end, AstNode parent,
                               Expression expression,
                               Block block) {
    super(start, end, parent);
    this.expression = expression;
    this.block = block;
  }

  public SynchronizedStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                               Expression expression,
                               Block block) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
    this.block = block;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }

  @JsonProperty("Block")
  public Block getBlock() {
    return block;
  }
}
