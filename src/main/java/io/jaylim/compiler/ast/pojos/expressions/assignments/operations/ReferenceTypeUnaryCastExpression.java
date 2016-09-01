package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.types.InterfaceType;
import io.jaylim.compiler.ast.pojos.types.ReferenceType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ReferenceTypeUnaryCastExpression extends CastExpression {

  private final ReferenceType referenceType;
  private final List<InterfaceType> interfaceTypeList;

  private final UnaryExpressionNotPlusMinus unaryExpressionNotPlusMinus;

  public ReferenceTypeUnaryCastExpression(Range range, AstNode parent,
                                          ReferenceType referenceType,
                                          List<InterfaceType> interfaceTypeList,
                                          UnaryExpressionNotPlusMinus unaryExpressionNotPlusMinus) {
    super(range, parent);
    this.referenceType = referenceType;
    this.interfaceTypeList = interfaceTypeList;
    this.unaryExpressionNotPlusMinus = unaryExpressionNotPlusMinus;
  }

  public ReferenceTypeUnaryCastExpression(Position start, Position end, AstNode parent,
                                          ReferenceType referenceType,
                                          List<InterfaceType> interfaceTypeList,
                                          UnaryExpressionNotPlusMinus unaryExpressionNotPlusMinus) {
    super(start, end, parent);
    this.referenceType = referenceType;
    this.interfaceTypeList = interfaceTypeList;
    this.unaryExpressionNotPlusMinus = unaryExpressionNotPlusMinus;
  }

  public ReferenceTypeUnaryCastExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                          ReferenceType referenceType,
                                          List<InterfaceType> interfaceTypeList,
                                          UnaryExpressionNotPlusMinus unaryExpressionNotPlusMinus) {
    super(startLine, startCol, endLine, endCol, parent);
    this.referenceType = referenceType;
    this.interfaceTypeList = interfaceTypeList;
    this.unaryExpressionNotPlusMinus = unaryExpressionNotPlusMinus;
  }

  @JsonProperty("ReferenceType")
  public ReferenceType getReferenceType() {
    return referenceType;
  }

  @JsonProperty("InterfaceTypeList")
  public List<InterfaceType> getInterfaceTypeList() {
    return interfaceTypeList;
  }

  @JsonProperty("UnaryExpressionNotPlusMinus")
  public UnaryExpressionNotPlusMinus getUnaryExpressionNotPlusMinus() {
    return unaryExpressionNotPlusMinus;
  }
}
