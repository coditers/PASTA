package codit.ast.pojos.expressions.primaries.fieldaccess;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BasicFieldAccess extends FieldAccess
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
               LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final String identifier;

  public BasicFieldAccess(Range range, AstNode parent, String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public BasicFieldAccess(Position start, Position end, AstNode parent, String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public BasicFieldAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent, String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }
}
