package codit.ast.pojos.expressions.primaries.fieldaccess;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.interfacearray.LfDefaultArrayAccess;
import codit.ast.pojos.expressions.primaries.interfacearray.LfNoArrayAccess;
import codit.ast.pojos.expressions.primaries.interfaceprimary.LfPrimary;
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
