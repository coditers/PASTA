package io.jaylim.compiler.ast.pojos.statements.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.expressions.StatementExpressionList;
import io.jaylim.compiler.ast.pojos.statements.Statement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BasicForStatement extends ForStatement {

  private final ForInit forInit;

  private final Expression forCondition;

  private final StatementExpressionList statementExpressionList;

  private final Statement statement;

  public BasicForStatement(Range range, AstNode parent,
                           ForInit forInit,
                           Expression forCondition,
                           StatementExpressionList statementExpressionList,
                           Statement statement) {
    super(range, parent);
    this.forInit = forInit;
    this.forCondition = forCondition;
    this.statementExpressionList = statementExpressionList;
    this.statement = statement;
  }

  public BasicForStatement(Position start, Position end, AstNode parent,
                           ForInit forInit,
                           Expression forCondition,
                           StatementExpressionList statementExpressionList,
                           Statement statement) {
    super(start, end, parent);
    this.forInit = forInit;
    this.forCondition = forCondition;
    this.statementExpressionList = statementExpressionList;
    this.statement = statement;
  }

  public BasicForStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                           ForInit forInit,
                           Expression forCondition,
                           StatementExpressionList statementExpressionList,
                           Statement statement) {
    super(startLine, startCol, endLine, endCol, parent);
    this.forInit = forInit;
    this.forCondition = forCondition;
    this.statementExpressionList = statementExpressionList;
    this.statement = statement;
  }

  @JsonProperty("ForInit")
  public ForInit getForInit() {
    return forInit;
  }

  @JsonProperty("ForCondition")
  public Expression getForCondition() {
    return forCondition;
  }

  @JsonProperty("StatementExpressionList")
  public StatementExpressionList getStatementExpressionList() {
    return statementExpressionList;
  }

  @JsonProperty("Statement")
  public Statement getStatement() {
    return statement;
  }
}
