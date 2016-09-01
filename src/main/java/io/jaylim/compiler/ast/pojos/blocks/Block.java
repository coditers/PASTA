package io.jaylim.compiler.ast.pojos.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.lambdas.LambdaBody;
import io.jaylim.compiler.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Block extends AstNode implements LambdaBody, StatementWithoutTrailingSubstatement {

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

  @JsonProperty("BlockStatements")
  public BlockStatements getBlockStatements() {
    return blockStatements;
  }
}
