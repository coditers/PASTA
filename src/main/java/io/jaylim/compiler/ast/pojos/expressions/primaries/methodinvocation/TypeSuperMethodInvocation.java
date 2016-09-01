package io.jaylim.compiler.ast.pojos.expressions.primaries.methodinvocation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.names.TypeName;
import io.jaylim.compiler.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeSuperMethodInvocation extends MethodInvocation
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final TypeName typeName;

  private final TypeArguments typeArguments;
  private final String identifier;
  private final List<Expression> argumentList;

  public TypeSuperMethodInvocation(Range range, AstNode parent, TypeName typeName, TypeArguments typeArguments, String identifier, List<Expression> argumentList) {
    super(range, parent);
    this.typeName = typeName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
  }

  public TypeSuperMethodInvocation(Position start, Position end, AstNode parent, TypeName typeName, TypeArguments typeArguments, String identifier, List<Expression> argumentList) {
    super(start, end, parent);
    this.typeName = typeName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
  }

  public TypeSuperMethodInvocation(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName, TypeArguments typeArguments, String identifier, List<Expression> argumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
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

  @JsonProperty("ArgumentList")
  public List<Expression> getArgumentList() {
    return argumentList;
  }
}
