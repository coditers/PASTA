package codit.ast.pojos.statements.withoutsubstatement.asserts;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class AssertStatement extends AstNode implements StatementWithoutTrailingSubstatement {
  public AssertStatement(Range range, AstNode parent) {
    super(range, parent);
  }

  public AssertStatement(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public AssertStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
