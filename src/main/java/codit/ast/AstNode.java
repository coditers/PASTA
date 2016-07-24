package codit.ast;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

/**
 * Created by Jisung on 7/19/2016.
 */
public abstract class AstNode {

  @NotNull
  private final Range range;

  @Nullable
  private AstNode parent;

  public AstNode(Range range, AstNode parent) {
    this.range = range;
    this.parent = parent;
  }

  public AstNode(Position start, Position end, AstNode parent) {
    this.range = new Range(start, end);
    this.parent = parent;
  }

  public AstNode(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    this.range = new Range(startLine, startCol, endLine, endCol);
    this.parent = parent;
  }

  public Range getRange() {
    return range;
  }

  public AstNode getParent() {
    return parent;
  }
}
