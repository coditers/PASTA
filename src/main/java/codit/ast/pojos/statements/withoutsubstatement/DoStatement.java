package codit.ast.pojos.statements.withoutsubstatement;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.statements.Statement;
import codit.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class DoStatement extends AstNode implements StatementWithoutTrailingSubstatement {

  private final Statement statement;
  private final Expression expression;

  public DoStatement(Range range, AstNode parent,
                     Statement statement,
                     Expression expression) {
    super(range, parent);
    this.statement = statement;
    this.expression = expression;
  }

  public DoStatement(Position start, Position end, AstNode parent,
                     Statement statement,
                     Expression expression) {
    super(start, end, parent);
    this.statement = statement;
    this.expression = expression;
  }

  public DoStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                     Statement statement,
                     Expression expression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.statement = statement;
    this.expression = expression;
  }
}
