package io.jaylim.compiler.ast.pojos.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.blocks.Block;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class StaticInitializer extends ClassBodyDeclaration {

  private final Block block;

  public StaticInitializer(Range range, AstNode parent,
                           Block block) {
    super(range, parent);
    this.block = block;
  }

  public StaticInitializer(Position start, Position end, AstNode parent,
                           Block block) {
    super(start, end, parent);
    this.block = block;
  }

  public StaticInitializer(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                           Block block) {
    super(startLine, startCol, endLine, endCol, parent);
    this.block = block;
  }

  @JsonProperty("Block")
  public Block getBlock() {
    return block;
  }
}
