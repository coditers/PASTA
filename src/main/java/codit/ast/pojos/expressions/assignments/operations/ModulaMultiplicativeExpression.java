package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ModulaMultiplicativeExpression extends MultiplicativeExpression {

  private final MultiplicativeExpression multiplicativeExpression;
  private final UnaryExpression unaryExpression;

  public ModulaMultiplicativeExpression(Range range, AstNode parent, MultiplicativeExpression multiplicativeExpression, UnaryExpression unaryExpression) {
    super(range, parent);
    this.multiplicativeExpression = multiplicativeExpression;
    this.unaryExpression = unaryExpression;
  }

  public ModulaMultiplicativeExpression(Position start, Position end, AstNode parent, MultiplicativeExpression multiplicativeExpression, UnaryExpression unaryExpression) {
    super(start, end, parent);
    this.multiplicativeExpression = multiplicativeExpression;
    this.unaryExpression = unaryExpression;
  }

  public ModulaMultiplicativeExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, MultiplicativeExpression multiplicativeExpression, UnaryExpression unaryExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.multiplicativeExpression = multiplicativeExpression;
    this.unaryExpression = unaryExpression;
  }
}
