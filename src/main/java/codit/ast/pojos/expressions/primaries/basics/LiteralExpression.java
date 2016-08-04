package codit.ast.pojos.expressions.primaries.basics;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.literals.Literal;

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
}
