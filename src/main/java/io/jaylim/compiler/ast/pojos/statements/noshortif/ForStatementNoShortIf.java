package io.jaylim.compiler.ast.pojos.statements.noshortif;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.statements.StatementNoShortIf;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ForStatementNoShortIf extends AstNode implements StatementNoShortIf {
  public ForStatementNoShortIf(Range range, AstNode parent) {
    super(range, parent);
  }

  public ForStatementNoShortIf(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ForStatementNoShortIf(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
