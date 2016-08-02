package codit.ast.pojos.statements.withoutsubstatement;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ContinueStatement extends AstNode implements StatementWithoutTrailingSubstatement {

  private final String identifier;

  public ContinueStatement(Range range, AstNode parent,
                           String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public ContinueStatement(Position start, Position end, AstNode parent,
                           String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public ContinueStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                           String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }
}
