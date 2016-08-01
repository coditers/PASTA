package codit.ast.pojos.statements.withoutsubstatement;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.statements.StatementWithoutTrailingSubstatement;

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
