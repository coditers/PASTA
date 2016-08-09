package codit.ast.pojos.classes;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.blocks.Block;

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
}
