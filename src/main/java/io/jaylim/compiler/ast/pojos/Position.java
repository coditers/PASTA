package io.jaylim.compiler.ast.pojos;

/**
 * Created by Jisung on 7/19/2016.
 */
public class Position {
  public final int line;
  public final int column;

  public Position(int line, int column) {
    this.line = line;
    this.column = column;

  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Position)) return false;

    Position position = (Position) o;

    if (line != position.line) return false;
    return column == position.column;

  }

  @Override
  public int hashCode() {
    int result = line;
    result = 31 * result + column;
    return result;
  }
}
