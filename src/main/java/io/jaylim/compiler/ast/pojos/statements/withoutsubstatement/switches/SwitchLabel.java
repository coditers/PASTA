package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement.switches;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class SwitchLabel extends AstNode {
  public SwitchLabel(Range range, AstNode parent) {
    super(range, parent);
  }

  public SwitchLabel(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public SwitchLabel(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
