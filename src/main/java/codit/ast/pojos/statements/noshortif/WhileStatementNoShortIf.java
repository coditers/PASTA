package codit.ast.pojos.statements.noshortif;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.statements.StatementNoShortIf;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class WhileStatementNoShortIf extends AstNode implements StatementNoShortIf {

  private final Expression expression;
  private final StatementNoShortIf statementNoShortIf;

  public WhileStatementNoShortIf(Range range, AstNode parent,
                                 Expression expression,
                                 StatementNoShortIf statementNoShortIf) {
    super(range, parent);
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
  }

  public WhileStatementNoShortIf(Position start, Position end, AstNode parent,
                                 Expression expression,
                                 StatementNoShortIf statementNoShortIf) {
    super(start, end, parent);
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
  }

  public WhileStatementNoShortIf(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                 Expression expression,
                                 StatementNoShortIf statementNoShortIf) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }

  @JsonProperty("StatementNoShortIf")
  public StatementNoShortIf getStatementNoShortIf() {
    return statementNoShortIf;
  }
}
