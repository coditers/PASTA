package codit.ast.pojos.expressions;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.interfaces.ElementValue;
import codit.ast.pojos.statements.AssignmentExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ConditionalExpression extends AssignmentExpression implements ElementValue {

  /* WARN - Are not implemented yet
   *
   * public abstract class ConditionalOrExpression | conditionalOrExpression
   * public class NormalConditionalOrExpression | conditionalOrExpression '?' expression ':' conditionalExpression
   *
   **/

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
