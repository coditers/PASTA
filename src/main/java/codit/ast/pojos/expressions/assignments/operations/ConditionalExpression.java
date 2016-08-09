package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.assignments.AssignmentExpression;
import codit.ast.pojos.interfaces.ElementValue;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ConditionalExpression extends AssignmentExpression implements ElementValue {

  public ConditionalExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public ConditionalExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ConditionalExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
