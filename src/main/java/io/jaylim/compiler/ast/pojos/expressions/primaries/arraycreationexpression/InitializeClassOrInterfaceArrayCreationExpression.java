package io.jaylim.compiler.ast.pojos.expressions.primaries.arraycreationexpression;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.classes.ArrayInitializer;
import io.jaylim.compiler.ast.pojos.types.ClassOrInterfaceType;
import io.jaylim.compiler.ast.pojos.types.Dims;

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

  @JsonProperty("ClassOrInterfaceType")
  public ClassOrInterfaceType getClassOrInterfaceType() {
    return classOrInterfaceType;
  }

  @JsonProperty("Dims")
  public Dims getDims() {
    return dims;
  }

  @JsonProperty("ArrayInitializer")
  public ArrayInitializer getArrayInitializer() {
    return arrayInitializer;
  }
}
