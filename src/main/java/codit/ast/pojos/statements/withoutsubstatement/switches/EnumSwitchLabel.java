package codit.ast.pojos.statements.withoutsubstatement.switches;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class EnumSwitchLabel extends SwitchLabel {

  private final String enumConstantName;

  public EnumSwitchLabel(Range range, AstNode parent, String enumConstantName) {
    super(range, parent);
    this.enumConstantName = enumConstantName;
  }

  public EnumSwitchLabel(Position start, Position end, AstNode parent, String enumConstantName) {
    super(start, end, parent);
    this.enumConstantName = enumConstantName;
  }

  public EnumSwitchLabel(int startLine, int startCol, int endLine, int endCol, AstNode parent, String enumConstantName) {
    super(startLine, startCol, endLine, endCol, parent);
    this.enumConstantName = enumConstantName;
  }
}
