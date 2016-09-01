package io.jaylim.compiler.ast.pojos.expressions.primaries.methodreference;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BasicSuperMethodReference extends MethodReference
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final TypeArguments typeArguments;
  private final String identifier;

  public BasicSuperMethodReference(Range range, AstNode parent,
                                   TypeArguments typeArguments,
                                   String identifier) {
    super(range, parent);
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public BasicSuperMethodReference(Position start, Position end, AstNode parent,
                                   TypeArguments typeArguments,
                                   String identifier) {
    super(start, end, parent);
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public BasicSuperMethodReference(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   TypeArguments typeArguments,
                                   String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeArguments = typeArguments;
    this.identifier = identifier;
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
