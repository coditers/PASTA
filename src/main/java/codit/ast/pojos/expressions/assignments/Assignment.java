package codit.ast.pojos.expressions.assignments;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.StatementExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Assignment extends AssignmentExpression implements StatementExpression {

  private final LeftHandSide leftHandSide;
  private final String assignmentOperator;
  private final Expression expression;

  public Assignment(Range range, AstNode parent,
                    LeftHandSide leftHandSide,
                    String assignmentOperator,
                    Expression expression) {
    super(range, parent);
    this.leftHandSide = leftHandSide;
    this.assignmentOperator = assignmentOperator;
    this.expression = expression;
  }

  public Assignment(Position start, Position end, AstNode parent,
                    LeftHandSide leftHandSide,
                    String assignmentOperator,
                    Expression expression) {
    super(start, end, parent);
    this.leftHandSide = leftHandSide;
    this.assignmentOperator = assignmentOperator;
    this.expression = expression;
  }

  public Assignment(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                    LeftHandSide leftHandSide,
                    String assignmentOperator,
                    Expression expression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.leftHandSide = leftHandSide;
    this.assignmentOperator = assignmentOperator;
    this.expression = expression;
  }

  @JsonProperty("LeftHandSide")
  public LeftHandSide getLeftHandSide() {
    return leftHandSide;
  }

  @JsonProperty("AssignmentOperator")
  public String getAssignmentOperator() {
    return assignmentOperator;
  }
  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }
}
