package io.jaylim.compiler.ast.pojos.expressions.primaries.arraycreationexpression;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.types.Dims;
import io.jaylim.compiler.ast.pojos.types.PrimitiveType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BasicPrimitiveArrayCreationExpression extends ArrayCreationExpression {

  private final PrimitiveType primitiveType;
  private final List<DimExpr> dimExprList;
  private final Dims dims;

  public BasicPrimitiveArrayCreationExpression(Range range, AstNode parent,
                                               PrimitiveType primitiveType,
                                               List<DimExpr> dimExprList,
                                               Dims dims) {
    super(range, parent);
    this.primitiveType = primitiveType;
    this.dimExprList = dimExprList;
    this.dims = dims;
  }

  public BasicPrimitiveArrayCreationExpression(Position start, Position end, AstNode parent,
                                               PrimitiveType primitiveType,
                                               List<DimExpr> dimExprList,
                                               Dims dims) {
    super(start, end, parent);
    this.primitiveType = primitiveType;
    this.dimExprList = dimExprList;
    this.dims = dims;
  }

  public BasicPrimitiveArrayCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                               PrimitiveType primitiveType,
                                               List<DimExpr> dimExprList,
                                               Dims dims) {
    super(startLine, startCol, endLine, endCol, parent);
    this.primitiveType = primitiveType;
    this.dimExprList = dimExprList;
    this.dims = dims;
  }

  @JsonProperty("PrimitiveType")
  public PrimitiveType getPrimitiveType() {
    return primitiveType;
  }

  @JsonProperty("DimExprList")
  public List<DimExpr> getDimExprList() {
    return dimExprList;
  }

  @JsonProperty("Dims")
  public Dims getDims() {
    return dims;
  }
}
