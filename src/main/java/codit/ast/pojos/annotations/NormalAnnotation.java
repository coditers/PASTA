package codit.ast.pojos.annotations;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
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
}
