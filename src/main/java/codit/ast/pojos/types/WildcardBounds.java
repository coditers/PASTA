package codit.ast.pojos.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class WildcardBounds extends AstNode {

  private final boolean isExtends;
  private final ReferenceType referenceType;

  public WildcardBounds(Range range, AstNode parent,
                        boolean isExtends,
                        ReferenceType referenceType) {
    super(range, parent);
    this.isExtends = isExtends;
    this.referenceType = referenceType;
  }

  public WildcardBounds(Position start, Position end, AstNode parent,
                        boolean isExtends,
                        ReferenceType referenceType) {
    super(start, end, parent);
    this.isExtends = isExtends;
    this.referenceType = referenceType;
  }

  public WildcardBounds(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                        boolean isExtends,
                        ReferenceType referenceType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.isExtends = isExtends;
    this.referenceType = referenceType;
  }

  @JsonProperty("isExtends")
  public boolean isExtends() {
    return isExtends;
  }

  @JsonProperty("ReferenceType")
  public ReferenceType getReferenceType() {
    return referenceType;
  }
}
