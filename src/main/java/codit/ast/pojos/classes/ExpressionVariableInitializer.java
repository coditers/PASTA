package codit.ast.pojos.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.variables.VariableInitializer;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ExpressionVariableInitializer extends VariableInitializer {

  private final Expression expression;

  public ExpressionVariableInitializer(Range range, AstNode parent, Expression expression) {
    super(range, parent);
    this.expression = expression;
  }

  public ExpressionVariableInitializer(Position start, Position end, AstNode parent, Expression expression) {
    super(start, end, parent);
    this.expression = expression;
  }

  public ExpressionVariableInitializer(int startLine, int startCol, int endLine, int endCol, AstNode parent, Expression expression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }
}
