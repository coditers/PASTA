package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement.switches;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

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
