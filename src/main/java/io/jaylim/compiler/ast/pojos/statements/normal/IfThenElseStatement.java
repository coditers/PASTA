package io.jaylim.compiler.ast.pojos.statements.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.statements.Statement;
import io.jaylim.compiler.ast.pojos.statements.StatementNoShortIf;

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

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }

  @JsonProperty("StatementNoShortIf")
  public StatementNoShortIf getStatementNoShortIf() {
    return statementNoShortIf;
  }

  @JsonProperty("Statement")
  public Statement getStatement() {
    return statement;
  }
}
