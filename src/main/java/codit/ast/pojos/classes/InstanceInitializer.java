package codit.ast.pojos.classes;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.blocks.Block;

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
}
