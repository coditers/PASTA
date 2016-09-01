package io.jaylim.compiler.ast.pojos.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.blocks.Block;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InstanceInitializer extends ClassBodyDeclaration {
  private final Block block;

  public InstanceInitializer(Range range, AstNode parent,
                             Block block) {
    super(range, parent);
    this.block = block;
  }

  public InstanceInitializer(Position start, Position end, AstNode parent,
                             Block block) {
    super(start, end, parent);
    this.block = block;
  }

  public InstanceInitializer(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                             Block block) {
    super(startLine, startCol, endLine, endCol, parent);
    this.block = block;
  }

  @JsonProperty("Block")
  public Block getBlock() {
    return block;
  }
}
