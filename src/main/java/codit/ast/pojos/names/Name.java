package codit.ast.pojos.names;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Name extends AstNode {

  private final String identifier;

  public Name(Range range, AstNode parent,
              String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public Name(Position start, Position end, AstNode parent,
              String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public Name(int startLine, int startCol, int endLine, int endCol, AstNode parent,
              String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }
}
