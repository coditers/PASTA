package codit.ast.pojos.expressions.primaries.arraycreationexpression;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.classes.ArrayInitializer;
import codit.ast.pojos.types.ClassOrInterfaceType;
import codit.ast.pojos.types.Dims;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InitializeClassOrInterfaceArrayCreationExpression extends ArrayCreationExpression {

  private final ClassOrInterfaceType classOrInterfaceType;
  private final Dims dims;
  private final ArrayInitializer arrayInitializer;

  public InitializeClassOrInterfaceArrayCreationExpression(Range range, AstNode parent,
                                                           ClassOrInterfaceType classOrInterfaceType,
                                                           Dims dims,
                                                           ArrayInitializer arrayInitializer) {
    super(range, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.dims = dims;
    this.arrayInitializer = arrayInitializer;
  }

  public InitializeClassOrInterfaceArrayCreationExpression(Position start, Position end, AstNode parent,
                                                           ClassOrInterfaceType classOrInterfaceType,
                                                           Dims dims,
                                                           ArrayInitializer arrayInitializer) {
    super(start, end, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.dims = dims;
    this.arrayInitializer = arrayInitializer;
  }

  public InitializeClassOrInterfaceArrayCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                                           ClassOrInterfaceType classOrInterfaceType,
                                                           Dims dims,
                                                           ArrayInitializer arrayInitializer) {
    super(startLine, startCol, endLine, endCol, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.dims = dims;
    this.arrayInitializer = arrayInitializer;
  }
}
