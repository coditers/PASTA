package io.jaylim.compiler.ast.pojos.expressions.primaries.methodreference;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.names.TypeName;
import io.jaylim.compiler.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeSuperMethodReference extends MethodReference
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final TypeName typeName;
  private final TypeArguments typeArguments;
  private final String identifier;

  public TypeSuperMethodReference(Range range, AstNode parent,
                                  TypeName typeName,
                                  TypeArguments typeArguments,
                                  String identifier) {
    super(range, parent);
    this.typeName = typeName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public TypeSuperMethodReference(Position start, Position end, AstNode parent,
                                  TypeName typeName,
                                  TypeArguments typeArguments,
                                  String identifier) {
    super(start, end, parent);
    this.typeName = typeName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public TypeSuperMethodReference(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                  TypeName typeName,
                                  TypeArguments typeArguments,
                                  String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  @JsonProperty("TypeName")
  public TypeName getTypeName() {
    return typeName;
  }

  @JsonProperty("TypeArguments")
  public TypeArguments getTypeArguments() {
    return typeArguments;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }
}
