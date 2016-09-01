package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class EmptyStatement extends AstNode implements StatementWithoutTrailingSubstatement {
  public EmptyStatement(Range range, AstNode parent) {
    super(range, parent);
  }

  public EmptyStatement(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public EmptyStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
