package codit.ast.pojos.statements.withoutsubstatement.asserts;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnaryAssertStatement extends AssertStatement {

  private final Expression expression;

  public UnaryAssertStatement(Range range, AstNode parent, Expression expression) {
    super(range, parent);
    this.expression = expression;
  }

  public UnaryAssertStatement(Position start, Position end, AstNode parent, Expression expression) {
    super(start, end, parent);
    this.expression = expression;
  }

  public UnaryAssertStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent, Expression expression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }
}
