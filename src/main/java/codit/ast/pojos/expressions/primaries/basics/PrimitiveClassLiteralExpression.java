package codit.ast.pojos.expressions.primaries.basics;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PrimitiveClassLiteralExpression)) return false;
    if (!super.equals(o)) return false;

    PrimitiveClassLiteralExpression that = (PrimitiveClassLiteralExpression) o;

    if (numberOfBracket != that.numberOfBracket) return false;
    return unannPrimitiveType != null ? unannPrimitiveType.equals(that.unannPrimitiveType) : that.unannPrimitiveType == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (unannPrimitiveType != null ? unannPrimitiveType.hashCode() : 0);
    result = 31 * result + numberOfBracket;
    return result;
  }

  @JsonProperty("UnannPrimitiveType")
  public UnannPrimitiveType getUnannPrimitiveType() {
    return unannPrimitiveType;
  }

  @JsonProperty("NumberOfBracket")
  public int getNumberOfBracket() {
    return numberOfBracket;
  }
}
