package io.jaylim.compiler.ast.pojos.expressions.primaries.methodinvocation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfPrimary;
import io.jaylim.compiler.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PostfixMethodInvocation extends MethodInvocation
    implements DefaultArrayLfPrimary, LfnoArrayLfPrimary {

  private final TypeArguments typeArguments;
  private final String identifier;
  private final List<Expression> argumentList;

  public PostfixMethodInvocation(Range range, AstNode parent, TypeArguments typeArguments, String identifier, List<Expression> argumentList) {
    super(range, parent);
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
  }

  public PostfixMethodInvocation(Position start, Position end, AstNode parent, TypeArguments typeArguments, String identifier, List<Expression> argumentList) {
    super(start, end, parent);
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
  }

  public PostfixMethodInvocation(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeArguments typeArguments, String identifier, List<Expression> argumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
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
