package io.jaylim.compiler.ast.pojos.statements.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.statements.Statement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class WhileStatement extends AstNode implements Statement {

  private final Expression expression;
  private final Statement statement;

  public WhileStatement(Range range, AstNode parent,
                        Expression expression,
                        Statement statement) {
    super(range, parent);
    this.expression = expression;
    this.statement = statement;
  }

  public WhileStatement(Position start, Position end, AstNode parent,
                        Expression expression,
                        Statement statement) {
    super(start, end, parent);
    this.expression = expression;
    this.statement = statement;
  }

  public WhileStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                        Expression expression,
                        Statement statement) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
    this.statement = statement;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }

  @JsonProperty("Statement")
  public Statement getStatement() {
    return statement;
  }
}
