package codit.ast.pojos.statements.normal;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.statements.Statement;
import codit.ast.pojos.statements.StatementNoShortIf;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class IfThenElseStatement extends AstNode implements Statement {

  private final Expression expression;
  private final StatementNoShortIf statementNoShortIf;
  private final Statement statement;

  public IfThenElseStatement(Range range, AstNode parent,
                             Expression expression,
                             StatementNoShortIf statementNoShortIf,
                             Statement statement) {
    super(range, parent);
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
    this.statement = statement;
  }

  public IfThenElseStatement(Position start, Position end, AstNode parent,
                             Expression expression,
                             StatementNoShortIf statementNoShortIf,
                             Statement statement) {
    super(start, end, parent);
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
    this.statement = statement;
  }

  public IfThenElseStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                             Expression expression,
                             StatementNoShortIf statementNoShortIf,
                             Statement statement) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
    this.statement = statement;
  }
}
