package codit.ast.pojos.statements.withoutsubstatement.switches;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

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
}
