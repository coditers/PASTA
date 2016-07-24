package codit.ast;

/**
 * Created by Jisung on 7/19/2016.
 */
public class Range {
  private final Position start;
  private final Position end;

  public Range(Position start, Position end) {
    this.start = start;
    this.end = end;
  }

  public Range(int startLine, int startCol, int endLine, int endCol) {
    this.start = new Position(startLine, startCol);
    this.end = new Position(endLine, endCol);
  }

  public Position getStart() {
    return start;
  }

  public Position getEnd() {
    return end;
  }

  @Override
  public String toString() {
    return "[start " + start.line + ":" + start.column +
        " end " + end.line + ":" + end.column + " ]";
  }
}
