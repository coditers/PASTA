package codit.ast.pojos.expressions.assignments.operations;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.lambdas.LambdaExpression;
import codit.ast.pojos.types.InterfaceType;
import codit.ast.pojos.types.ReferenceType;

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
}
