package codit.ast.pojos.expressions.primaries.arraycreationexpression;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.types.Dims;
import codit.ast.pojos.types.PrimitiveType;

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
}
