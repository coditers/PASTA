package codit.ast.pojos.expressions.assignments.operations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.types.PrimitiveType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimitiveTypeCastExpression extends CastExpression {
  private final PrimitiveType primitiveType;
  private final UnaryExpression unaryExpression;

  public PrimitiveTypeCastExpression(Range range, AstNode parent, PrimitiveType primitiveType, UnaryExpression unaryExpression) {
    super(range, parent);
    this.primitiveType = primitiveType;
    this.unaryExpression = unaryExpression;
  }

  public PrimitiveTypeCastExpression(Position start, Position end, AstNode parent, PrimitiveType primitiveType, UnaryExpression unaryExpression) {
    super(start, end, parent);
    this.primitiveType = primitiveType;
    this.unaryExpression = unaryExpression;
  }

  public PrimitiveTypeCastExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, PrimitiveType primitiveType, UnaryExpression unaryExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.primitiveType = primitiveType;
    this.unaryExpression = unaryExpression;
  }
}
