package codit.ast.pojos.expressions.primaries.methodreference;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.names.ExpressionName;
import codit.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ExpressionMethodReference extends MethodReference
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final ExpressionName expressionName;
  private final TypeArguments typeArguments;
  private final String identifier;

  public ExpressionMethodReference(Range range, AstNode parent,
                                   ExpressionName expressionName,
                                   TypeArguments typeArguments,
                                   String identifier) {
    super(range, parent);
    this.expressionName = expressionName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public ExpressionMethodReference(Position start, Position end, AstNode parent,
                                   ExpressionName expressionName,
                                   TypeArguments typeArguments,
                                   String identifier) {
    super(start, end, parent);
    this.expressionName = expressionName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public ExpressionMethodReference(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   ExpressionName expressionName,
                                   TypeArguments typeArguments,
                                   String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expressionName = expressionName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  @JsonProperty("ExpressionName")
  public ExpressionName getExpressionName() {
    return expressionName;
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
