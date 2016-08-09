package codit.ast.pojos.annotations;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MarkerAnnotation extends Annotation {
  private final TypeName typeName;

  public MarkerAnnotation(Range range, AstNode parent, TypeName typeName) {
    super(range, parent);
    this.typeName = typeName;
  }

  public MarkerAnnotation(Position start, Position end, AstNode parent, TypeName typeName) {
    super(start, end, parent);
    this.typeName = typeName;
  }

  public MarkerAnnotation(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
  }

  @JsonProperty("TypeName")
  public TypeName getTypeName() {
    return typeName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MarkerAnnotation)) return false;
    if (!super.equals(o)) return false;

    MarkerAnnotation that = (MarkerAnnotation) o;

    return typeName != null ? typeName.equals(that.typeName) : that.typeName == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
    return result;
  }
}
