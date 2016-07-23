package codit.ast.pojos.names;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Name extends AstNode {

  private final String identifier;

  public Name(Range range,
              String identifier) {
    super(range);
    this.identifier = identifier;
  }

  public Name(Position start, Position end,
              String identifier) {
    super(start, end);
    this.identifier = identifier;
  }

  public Name(int startLine, int startCol, int endLine, int endCol,
              String identifier) {
    super(startLine, startCol, endLine, endCol);
    this.identifier = identifier;
  }
}
