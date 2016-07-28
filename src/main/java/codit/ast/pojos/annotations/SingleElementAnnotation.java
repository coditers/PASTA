package codit.ast.pojos.annotations;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.interfaces.ElementValue;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SingleElementAnnotation extends Annotation {

  private final TypeName typeName;
  private final ElementValue elementValue;

  public SingleElementAnnotation(Range range, AstNode parent, TypeName typeName, ElementValue elementValue) {
    super(range, parent);
    this.typeName = typeName;
    this.elementValue = elementValue;
  }

  public SingleElementAnnotation(Position start, Position end, AstNode parent, TypeName typeName, ElementValue elementValue) {
    super(start, end, parent);
    this.typeName = typeName;
    this.elementValue = elementValue;
  }

  public SingleElementAnnotation(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName, ElementValue elementValue) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
    this.elementValue = elementValue;
  }
}
