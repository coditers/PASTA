package codit.ast.pojos.expressions.primaries.basics;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.types.unann.UnannPrimitiveType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimitiveClassLiteralExpression extends BasicExpression
    implements DefaultArrayLfnoPrimary, LfnoArrayLfnoPrimary {

  private final UnannPrimitiveType unannPrimitiveType;
  private final int numberOfBracket;

  public PrimitiveClassLiteralExpression(Range range, AstNode parent,
                                         UnannPrimitiveType unannPrimitiveType,
                                         int numberOfBracket) {
    super(range, parent);
    this.unannPrimitiveType = unannPrimitiveType;
    this.numberOfBracket = numberOfBracket;
  }

  public PrimitiveClassLiteralExpression(Position start, Position end, AstNode parent,
                                         UnannPrimitiveType unannPrimitiveType,
                                         int numberOfBracket) {
    super(start, end, parent);
    this.unannPrimitiveType = unannPrimitiveType;
    this.numberOfBracket = numberOfBracket;
  }

  public PrimitiveClassLiteralExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                         UnannPrimitiveType unannPrimitiveType,
                                         int numberOfBracket) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unannPrimitiveType = unannPrimitiveType;
    this.numberOfBracket = numberOfBracket;
  }
}
