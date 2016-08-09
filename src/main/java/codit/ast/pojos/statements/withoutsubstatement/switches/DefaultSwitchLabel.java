package codit.ast.pojos.statements.withoutsubstatement.switches;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class DefaultSwitchLabel extends SwitchLabel {
  public DefaultSwitchLabel(Range range, AstNode parent) {
    super(range, parent);
  }

  public DefaultSwitchLabel(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public DefaultSwitchLabel(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
