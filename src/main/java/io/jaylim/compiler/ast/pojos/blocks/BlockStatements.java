package io.jaylim.compiler.ast.pojos.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

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

  @JsonProperty("BlockStatementList")
  public List<InBlockStatement> getBlockStatementList() {
    return blockStatementList;
  }
}
