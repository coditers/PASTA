package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.types.PrimitiveType;

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

  @JsonProperty("PrimitiveType")
  public PrimitiveType getPrimitiveType() {
    return primitiveType;
  }

  @JsonProperty("UnaryExpression")
  public UnaryExpression getUnaryExpression() {
    return unaryExpression;
  }
}
