package codit.ast.pojos.expressions.primaries.arraycreationexpression;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.types.ClassOrInterfaceType;
import codit.ast.pojos.types.Dims;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BasicClassOrInterfaceArrayCreationExpression extends ArrayCreationExpression {

  private final ClassOrInterfaceType classOrInterfaceType;
  private final List<DimExpr> dimExprList;
  private final Dims dims;

  public BasicClassOrInterfaceArrayCreationExpression(Range range, AstNode parent,
                                                      ClassOrInterfaceType classOrInterfaceType,
                                                      List<DimExpr> dimExprList,
                                                      Dims dims) {
    super(range, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.dimExprList = dimExprList;
    this.dims = dims;
  }

  public BasicClassOrInterfaceArrayCreationExpression(Position start, Position end, AstNode parent,
                                                      ClassOrInterfaceType classOrInterfaceType,
                                                      List<DimExpr> dimExprList,
                                                      Dims dims) {
    super(start, end, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.dimExprList = dimExprList;
    this.dims = dims;
  }

  public BasicClassOrInterfaceArrayCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                                      ClassOrInterfaceType classOrInterfaceType,
                                                      List<DimExpr> dimExprList,
                                                      Dims dims) {
    super(startLine, startCol, endLine, endCol, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.dimExprList = dimExprList;
    this.dims = dims;
  }
}
