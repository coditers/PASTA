package codit.ast.pojos.statements.normal;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.StatementExpressionList;
import codit.ast.pojos.statements.Statement;

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
}
