package codit.ast.pojos.expressions.assignments;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.Expression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Assignment extends AssignmentExpression {

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
}
