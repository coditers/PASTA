package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TimesMultiplicativeExpression extends MultiplicativeExpression {

  private final MultiplicativeExpression multiplicativeExpression;
  private final UnaryExpression unaryExpression;

  public TimesMultiplicativeExpression(Range range, AstNode parent, MultiplicativeExpression multiplicativeExpression, UnaryExpression unaryExpression) {
    super(range, parent);
    this.multiplicativeExpression = multiplicativeExpression;
    this.unaryExpression = unaryExpression;
  }

  public TimesMultiplicativeExpression(Position start, Position end, AstNode parent, MultiplicativeExpression multiplicativeExpression, UnaryExpression unaryExpression) {
    super(start, end, parent);
    this.multiplicativeExpression = multiplicativeExpression;
    this.unaryExpression = unaryExpression;
  }

  public TimesMultiplicativeExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, MultiplicativeExpression multiplicativeExpression, UnaryExpression unaryExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.multiplicativeExpression = multiplicativeExpression;
    this.unaryExpression = unaryExpression;
  }
}
