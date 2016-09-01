package io.jaylim.compiler.ast.pojos.statements.noshortif;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.expressions.StatementExpressionList;
import io.jaylim.compiler.ast.pojos.statements.StatementNoShortIf;
import io.jaylim.compiler.ast.pojos.statements.normal.ForInit;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BasicForStatementNoShortIf extends ForStatementNoShortIf {

  private final ForInit forInit;

  private final Expression forCondition;

  private final StatementExpressionList statementExpressionList;

  private final StatementNoShortIf statementNoShortIf;

  public BasicForStatementNoShortIf(Range range, AstNode parent,
                                    ForInit forInit,
                                    Expression forCondition,
                                    StatementExpressionList statementExpressionList,
                                    StatementNoShortIf statementNoShortIf) {
    super(range, parent);
    this.forInit = forInit;
    this.forCondition = forCondition;
    this.statementExpressionList = statementExpressionList;
    this.statementNoShortIf = statementNoShortIf;
  }

  public BasicForStatementNoShortIf(Position start, Position end, AstNode parent,
                                    ForInit forInit,
                                    Expression forCondition,
                                    StatementExpressionList statementExpressionList,
                                    StatementNoShortIf statementNoShortIf) {
    super(start, end, parent);
    this.forInit = forInit;
    this.forCondition = forCondition;
    this.statementExpressionList = statementExpressionList;
    this.statementNoShortIf = statementNoShortIf;
  }

  public BasicForStatementNoShortIf(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                    ForInit forInit,
                                    Expression forCondition,
                                    StatementExpressionList statementExpressionList,
                                    StatementNoShortIf statementNoShortIf) {
    super(startLine, startCol, endLine, endCol, parent);
    this.forInit = forInit;
    this.forCondition = forCondition;
    this.statementExpressionList = statementExpressionList;
    this.statementNoShortIf = statementNoShortIf;
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

  @JsonProperty("StatementNoShortIf")
  public StatementNoShortIf getStatementNoShortIf() {
    return statementNoShortIf;
  }
}
