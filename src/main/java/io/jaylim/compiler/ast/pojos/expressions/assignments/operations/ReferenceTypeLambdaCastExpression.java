package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.lambdas.LambdaExpression;
import io.jaylim.compiler.ast.pojos.types.InterfaceType;
import io.jaylim.compiler.ast.pojos.types.ReferenceType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ReferenceTypeLambdaCastExpression extends CastExpression {

  private final ReferenceType referenceType;
  private final List<InterfaceType> interfaceTypeList;
  private final LambdaExpression lambdaExpression;

  public ReferenceTypeLambdaCastExpression(Range range, AstNode parent,
                                           ReferenceType referenceType,
                                           List<InterfaceType> interfaceTypeList,
                                           LambdaExpression lambdaExpression) {
    super(range, parent);
    this.referenceType = referenceType;
    this.interfaceTypeList = interfaceTypeList;
    this.lambdaExpression = lambdaExpression;
  }

  public ReferenceTypeLambdaCastExpression(Position start, Position end, AstNode parent,
                                           ReferenceType referenceType,
                                           List<InterfaceType> interfaceTypeList,
                                           LambdaExpression lambdaExpression) {
    super(start, end, parent);
    this.referenceType = referenceType;
    this.interfaceTypeList = interfaceTypeList;
    this.lambdaExpression = lambdaExpression;
  }

  public ReferenceTypeLambdaCastExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                           ReferenceType referenceType,
                                           List<InterfaceType> interfaceTypeList,
                                           LambdaExpression lambdaExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.referenceType = referenceType;
    this.interfaceTypeList = interfaceTypeList;
    this.lambdaExpression = lambdaExpression;
  }

  @JsonProperty("ReferenceType")
  public ReferenceType getReferenceType() {
    return referenceType;
  }

  @JsonProperty("InterfaceTypeList")
  public List<InterfaceType> getInterfaceTypeList() {
    return interfaceTypeList;
  }

  @JsonProperty("LambdaExpression")
  public LambdaExpression getLambdaExpression() {
    return lambdaExpression;
  }
}
