package codit.ast.pojos.expressions.primaries.fieldaccess;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.assignments.LeftHandSide;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ReferenceFieldAccess extends FieldAccess
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary, LeftHandSide {

  private final TypeName typeName;
  private final String identifier;

  public ReferenceFieldAccess(Range range, AstNode parent, TypeName typeName, String identifier) {
    super(range, parent);
    this.typeName = typeName;
    this.identifier = identifier;
  }

  public ReferenceFieldAccess(Position start, Position end, AstNode parent, TypeName typeName, String identifier) {
    super(start, end, parent);
    this.typeName = typeName;
    this.identifier = identifier;
  }

  public ReferenceFieldAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName, String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
    this.identifier = identifier;
  }
}
