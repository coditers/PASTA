package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.StatementExpression;
import io.jaylim.compiler.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ExpressionStatement extends AstNode implements StatementWithoutTrailingSubstatement {

  private final StatementExpression statementExpression;

  public ExpressionStatement(Range range, AstNode parent,
                             StatementExpression statementExpression) {
    super(range, parent);
    this.statementExpression = statementExpression;
  }

  public ExpressionStatement(Position start, Position end, AstNode parent,
                             StatementExpression statementExpression) {
    super(start, end, parent);
    this.statementExpression = statementExpression;
  }

  public ExpressionStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                             StatementExpression statementExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.statementExpression = statementExpression;
  }

  @JsonProperty("StatementExpression")
  public StatementExpression getStatementExpression() {
    return statementExpression;
  }
}
