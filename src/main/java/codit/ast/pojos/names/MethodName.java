package codit.ast.pojos.names;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MethodName extends Name {
  public MethodName(Range range, AstNode parent, String identifier) {
    super(range, parent, identifier);
  }

  public MethodName(Position start, Position end, AstNode parent, String identifier) {
    super(start, end, parent, identifier);
  }

  public MethodName(int startLine, int startCol, int endLine, int endCol, AstNode parent, String identifier) {
    super(startLine, startCol, endLine, endCol, parent, identifier);
  }


}
