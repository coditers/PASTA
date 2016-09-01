package io.jaylim.compiler.ast.pojos.expressions.primaries.arraycreationexpression;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.types.ClassOrInterfaceType;
import io.jaylim.compiler.ast.pojos.types.Dims;

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

  @JsonProperty("ClassOrInterfaceType")
  public ClassOrInterfaceType getClassOrInterfaceType() {
    return classOrInterfaceType;
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
