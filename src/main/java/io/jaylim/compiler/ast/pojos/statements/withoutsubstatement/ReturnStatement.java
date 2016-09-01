package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ReturnStatement extends AstNode implements StatementWithoutTrailingSubstatement {

  private final Expression expression;

  public ReturnStatement(Range range, AstNode parent,
                         Expression expression) {
    super(range, parent);
    this.expression = expression;
  }

  public ReturnStatement(Position start, Position end, AstNode parent,
                         Expression expression) {
    super(start, end, parent);
    this.expression = expression;
  }

  public ReturnStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                         Expression expression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }
}
