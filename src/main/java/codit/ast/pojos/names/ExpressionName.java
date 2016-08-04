package codit.ast.pojos.names;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
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
}
