package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement.switches;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SwitchBlock extends AstNode {

  private final List<SwitchBlockStatementGroup> switchBlockStatementGroupList;
  private final List<SwitchLabel> switchLabelList;

  public SwitchBlock(Range range, AstNode parent,
                     List<SwitchBlockStatementGroup> switchBlockStatementGroupList,
                     List<SwitchLabel> switchLabelList) {
    super(range, parent);
    this.switchBlockStatementGroupList = switchBlockStatementGroupList;
    this.switchLabelList = switchLabelList;
  }

  public SwitchBlock(Position start, Position end, AstNode parent,
                     List<SwitchBlockStatementGroup> switchBlockStatementGroupList,
                     List<SwitchLabel> switchLabelList) {
    super(start, end, parent);
    this.switchBlockStatementGroupList = switchBlockStatementGroupList;
    this.switchLabelList = switchLabelList;
  }

  public SwitchBlock(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                     List<SwitchBlockStatementGroup> switchBlockStatementGroupList,
                     List<SwitchLabel> switchLabelList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.switchBlockStatementGroupList = switchBlockStatementGroupList;
    this.switchLabelList = switchLabelList;
  }

  @JsonProperty("SwitchBlockStatementGroupList")
  public List<SwitchBlockStatementGroup> getSwitchBlockStatementGroupList() {
    return switchBlockStatementGroupList;
  }

  @JsonProperty("SwitchLabelList")
  public List<SwitchLabel> getSwitchLabelList() {
    return switchLabelList;
  }
}
