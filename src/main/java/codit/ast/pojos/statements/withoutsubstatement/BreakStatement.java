package codit.ast.pojos.statements.withoutsubstatement;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BreakStatement extends AstNode implements StatementWithoutTrailingSubstatement {

  private final String identifier;

  public BreakStatement(Range range, AstNode parent,
                        String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public BreakStatement(Position start, Position end, AstNode parent,
                        String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public BreakStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                        String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }
}
