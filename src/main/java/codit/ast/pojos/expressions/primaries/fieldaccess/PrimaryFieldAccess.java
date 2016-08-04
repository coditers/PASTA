package codit.ast.pojos.expressions.primaries.fieldaccess;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.assignments.LeftHandSide;
import codit.ast.pojos.expressions.primaries.Primary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimaryFieldAccess extends FieldAccess
    implements DefaultArrayDefaultPrimary, LfnoArrayDefaultPrimary, LeftHandSide {

  private final Primary primary;
  private final String identifier;

  public PrimaryFieldAccess(Range range, AstNode parent, Primary primary, String identifier) {
    super(range, parent);
    this.primary = primary;
    this.identifier = identifier;
  }

  public PrimaryFieldAccess(Position start, Position end, AstNode parent, Primary primary, String identifier) {
    super(start, end, parent);
    this.primary = primary;
    this.identifier = identifier;
  }

  public PrimaryFieldAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent, Primary primary, String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.primary = primary;
    this.identifier = identifier;
  }
}
