package codit.ast.pojos.parameters;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class Parameter extends AstNode {

  public Parameter(Range range, AstNode parent) {
    super(range, parent);
  }

  public Parameter(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public Parameter(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}

