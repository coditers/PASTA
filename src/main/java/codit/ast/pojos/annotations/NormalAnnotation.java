package codit.ast.pojos.annotations;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.interfaces.ElementValuePair;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class NormalAnnotation extends Annotation {

  private final TypeName typeName;

  private final List<ElementValuePair> elementValuePairList;

  public NormalAnnotation(Range range, AstNode parent, TypeName typeName, List<ElementValuePair> elementValuePairList) {
    super(range, parent);
    this.typeName = typeName;
    this.elementValuePairList = elementValuePairList;
  }

  public NormalAnnotation(Position start, Position end, AstNode parent, TypeName typeName, List<ElementValuePair> elementValuePairList) {
    super(start, end, parent);
    this.typeName = typeName;
    this.elementValuePairList = elementValuePairList;
  }

  public NormalAnnotation(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName, List<ElementValuePair> elementValuePairList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
    this.elementValuePairList = elementValuePairList;
  }

  @JsonProperty("TypeName")
  public TypeName getTypeName() {
    return typeName;
  }

  @JsonProperty("ElementValuePairList")
  public List<ElementValuePair> getElementValuePairList() {
    return elementValuePairList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof NormalAnnotation)) return false;
    if (!super.equals(o)) return false;

    NormalAnnotation that = (NormalAnnotation) o;

    if (typeName != null ? !typeName.equals(that.typeName) : that.typeName != null) return false;
    return elementValuePairList != null ? elementValuePairList.equals(that.elementValuePairList) : that.elementValuePairList == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (typeName != null ? typeName.hashCode() : 0);
    result = 31 * result + (elementValuePairList != null ? elementValuePairList.hashCode() : 0);
    return result;
  }
}
