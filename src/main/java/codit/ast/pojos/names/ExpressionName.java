package codit.ast.pojos.names;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.assignments.LeftHandSide;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ExpressionName extends Name implements LeftHandSide {

  private final AmbiguousName prev;

  public ExpressionName(Range range, AstNode parent, String identifier, AmbiguousName prev) {
    super(range, parent, identifier);
    this.prev = prev;
  }

  public ExpressionName(Position start, Position end, AstNode parent, String identifier, AmbiguousName prev) {
    super(start, end, parent, identifier);
    this.prev = prev;
  }

  public ExpressionName(int startLine, int startCol, int endLine, int endCol, AstNode parent, String identifier, AmbiguousName prev) {
    super(startLine, startCol, endLine, endCol, parent, identifier);
    this.prev = prev;
  }

  @JsonProperty(value="prev")
  public AmbiguousName getPrev() {
    return prev;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ExpressionName)) return false;
    if (!super.equals(o)) return false;

    ExpressionName that = (ExpressionName) o;

    return prev != null ? prev.equals(that.prev) : that.prev == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (prev != null ? prev.hashCode() : 0);
    return result;
  }
}
