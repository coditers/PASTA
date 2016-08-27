package codit.ast.pojos.statements.withoutsubstatement.switches;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

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

  @JsonProperty("EnumConstantName")
  public String getEnumConstantName() {
    return enumConstantName;
  }
}
