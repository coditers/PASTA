package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.statements.Statement;
import io.jaylim.compiler.ast.pojos.statements.StatementWithoutTrailingSubstatement;

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

  @JsonProperty("Statement")
  public Statement getStatement() {
    return statement;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }
}
