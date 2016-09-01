package io.jaylim.compiler.ast.pojos;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Range)) return false;

    Range range = (Range) o;

    if (start != null ? !start.equals(range.start) : range.start != null) return false;
    return end != null ? end.equals(range.end) : range.end == null;

  }

  @Override
  public int hashCode() {
    int result = start != null ? start.hashCode() : 0;
    result = 31 * result + (end != null ? end.hashCode() : 0);
    return result;
  }
}
