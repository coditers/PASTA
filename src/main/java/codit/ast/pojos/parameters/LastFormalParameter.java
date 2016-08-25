package codit.ast.pojos.parameters;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jay Lim
 * @date 8/25/2016
 */
public abstract class LastFormalParameter extends AstNode {

  public LastFormalParameter(Range range, AstNode parent) {
    super(range, parent);
  }

  public LastFormalParameter(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public LastFormalParameter(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
