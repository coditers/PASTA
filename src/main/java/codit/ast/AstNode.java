package codit.ast;

/**
 * Created by Jisung on 7/19/2016.
 */
public abstract class AstNode {

  private final Range range;

  public AstNode(Range range) {
    this.range = range;
  }

  public AstNode(Position start, Position end) {
    this.range = new Range(start, end);
  }

  public AstNode(int startLine, int startCol, int endLine, int endCol) {
    this.range = new Range(startLine, startCol, endLine, endCol);
  }
}
