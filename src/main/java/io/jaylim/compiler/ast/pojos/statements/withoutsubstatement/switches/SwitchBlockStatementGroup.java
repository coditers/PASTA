package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement.switches;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.blocks.BlockStatements;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SwitchBlockStatementGroup extends AstNode {

  private final List<SwitchLabel> switchLabelList;
  private final BlockStatements blockStatements;

  public SwitchBlockStatementGroup(Range range, AstNode parent,
                                   List<SwitchLabel> switchLabelList,
                                   BlockStatements blockStatements) {
    super(range, parent);
    this.switchLabelList = switchLabelList;
    this.blockStatements = blockStatements;
  }

  public SwitchBlockStatementGroup(Position start, Position end, AstNode parent,
                                   List<SwitchLabel> switchLabelList,
                                   BlockStatements blockStatements) {
    super(start, end, parent);
    this.switchLabelList = switchLabelList;
    this.blockStatements = blockStatements;
  }

  public SwitchBlockStatementGroup(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   List<SwitchLabel> switchLabelList,
                                   BlockStatements blockStatements) {
    super(startLine, startCol, endLine, endCol, parent);
    this.switchLabelList = switchLabelList;
    this.blockStatements = blockStatements;
  }

  @JsonProperty("SwitchLabelList")
  public List<SwitchLabel> getSwitchLabelList() {
    return switchLabelList;
  }

  @JsonProperty("BlockStatements")
  public BlockStatements getBlockStatements() {
    return blockStatements;
  }
}
