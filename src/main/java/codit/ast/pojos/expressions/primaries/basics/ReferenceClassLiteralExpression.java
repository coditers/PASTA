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
public class ReferenceClassLiteralExpression extends BasicExpression
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
               LfnoArrayDefaultPrimary   , LfnoArrayLfnoPrimary {

  private final TypeName typeName;
  private final int numberOfBracket;

  public ReferenceClassLiteralExpression(Range range, AstNode parent, TypeName typeName, int numberOfBracket) {
    super(range, parent);
    this.typeName = typeName;
    this.numberOfBracket = numberOfBracket;
  }

  public ReferenceClassLiteralExpression(Position start, Position end, AstNode parent, TypeName typeName, int numberOfBracket) {
    super(start, end, parent);
    this.typeName = typeName;
    this.numberOfBracket = numberOfBracket;
  }

  public ReferenceClassLiteralExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName, int numberOfBracket) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
    this.numberOfBracket = numberOfBracket;
  }
}
