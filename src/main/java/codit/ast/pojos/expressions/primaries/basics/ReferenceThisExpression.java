package codit.ast.pojos.expressions.primaries.basics;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ReferenceThisExpression extends BasicExpression
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final TypeName typeName;

  public ReferenceThisExpression(Range range, AstNode parent, TypeName typeName) {
    super(range, parent);
    this.typeName = typeName;
  }

  public ReferenceThisExpression(Position start, Position end, AstNode parent, TypeName typeName) {
    super(start, end, parent);
    this.typeName = typeName;
  }

  public ReferenceThisExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
  }
}
