package codit.ast.pojos.expressions.primaries.methodinvocation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.names.ExpressionName;
import codit.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ExpressionMethodInvocation extends MethodInvocation
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final ExpressionName expressionName;
  private final TypeArguments typeArguments;
  private final String identifier;
  private final List<Expression> argumentList;

  public ExpressionMethodInvocation(Range range, AstNode parent, ExpressionName expressionName, TypeArguments typeArguments, String identifier, List<Expression> argumentList) {
    super(range, parent);
    this.expressionName = expressionName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
  }

  public ExpressionMethodInvocation(Position start, Position end, AstNode parent, ExpressionName expressionName, TypeArguments typeArguments, String identifier, List<Expression> argumentList) {
    super(start, end, parent);
    this.expressionName = expressionName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
  }

  public ExpressionMethodInvocation(int startLine, int startCol, int endLine, int endCol, AstNode parent, ExpressionName expressionName, TypeArguments typeArguments, String identifier, List<Expression> argumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expressionName = expressionName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
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

  @JsonProperty("ArgumentList")
  public List<Expression> getArgumentList() {
    return argumentList;
  }
}
