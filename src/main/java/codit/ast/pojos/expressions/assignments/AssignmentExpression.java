package codit.ast.pojos.expressions.assignments;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.Expression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class AssignmentExpression extends Expression {
  public AssignmentExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public AssignmentExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public AssignmentExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
