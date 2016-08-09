package codit.ast.pojos.expressions.primaries.fieldaccess;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PostfixFieldAccess extends FieldAccess
    implements DefaultArrayLfPrimary, LfnoArrayLfPrimary {

  private final String identifier;

  public PostfixFieldAccess(Range range, AstNode parent, String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public PostfixFieldAccess(Position start, Position end, AstNode parent, String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public PostfixFieldAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent, String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }
}
