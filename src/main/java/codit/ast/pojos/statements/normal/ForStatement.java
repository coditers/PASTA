package codit.ast.pojos.statements.normal;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.statements.Statement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ForStatement extends AstNode implements Statement {
  public ForStatement(Range range, AstNode parent) {
    super(range, parent);
  }

  public ForStatement(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ForStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
