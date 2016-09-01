package io.jaylim.compiler.ast.pojos.expressions.primaries.basics;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.literals.Literal;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LiteralExpression extends BasicExpression
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final Literal literal;

  public LiteralExpression(Range range, AstNode parent, Literal literal) {
    super(range, parent);
    this.literal = literal;
  }

  public LiteralExpression(Position start, Position end, AstNode parent, Literal literal) {
    super(start, end, parent);
    this.literal = literal;
  }

  public LiteralExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, Literal literal) {
    super(startLine, startCol, endLine, endCol, parent);
    this.literal = literal;
  }

  @JsonProperty("literal")
  public Literal getLiteral() {
    return literal;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof LiteralExpression)) return false;
    if (!super.equals(o)) return false;

    LiteralExpression that = (LiteralExpression) o;

    return literal != null ? literal.equals(that.literal) : that.literal == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (literal != null ? literal.hashCode() : 0);
    return result;
  }
}
