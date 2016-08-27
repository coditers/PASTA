package codit.ast.pojos.statements.withoutsubstatement;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ThrowStatement extends AstNode implements StatementWithoutTrailingSubstatement {

  private final Expression expression;

  public ThrowStatement(Range range, AstNode parent,
                        Expression expression) {
    super(range, parent);
    this.expression = expression;
  }

  public ThrowStatement(Position start, Position end, AstNode parent,
                        Expression expression) {
    super(start, end, parent);
    this.expression = expression;
  }

  public ThrowStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                        Expression expression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }
}
