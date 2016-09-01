package io.jaylim.compiler.ast.pojos.expressions.primaries.methodreference;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.types.ClassType;
import io.jaylim.compiler.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ClassMethodReference extends MethodReference
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final ClassType classType;
  private final TypeArguments typeArguments;

  public ClassMethodReference(Range range, AstNode parent,
                              ClassType classType,
                              TypeArguments typeArguments) {
    super(range, parent);
    this.classType = classType;
    this.typeArguments = typeArguments;
  }

  public ClassMethodReference(Position start, Position end, AstNode parent,
                              ClassType classType,
                              TypeArguments typeArguments) {
    super(start, end, parent);
    this.classType = classType;
    this.typeArguments = typeArguments;
  }

  public ClassMethodReference(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                              ClassType classType,
                              TypeArguments typeArguments) {
    super(startLine, startCol, endLine, endCol, parent);
    this.classType = classType;
    this.typeArguments = typeArguments;
  }

  @JsonProperty("ClassType")
  public ClassType getClassType() {
    return classType;
  }

  @JsonProperty("TypeArguments")
  public TypeArguments getTypeArguments() {
    return typeArguments;
  }
}
