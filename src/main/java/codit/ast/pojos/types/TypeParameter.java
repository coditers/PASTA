package codit.ast.pojos.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeParameter extends AstNode {
  private final List<Annotation> annotationList;
  private final String identifier;
  private final TypeBound typeBound;

  public TypeParameter(Range range, AstNode parent,
                       Collection<Annotation> annotationList,
                       String identifier,
                       TypeBound typeBound) {
    super(range, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.identifier = identifier;
    this.typeBound = typeBound;
  }

  public TypeParameter(Position start, Position end, AstNode parent,
                       Collection<Annotation> annotationList,
                       String identifier,
                       TypeBound typeBound) {
    super(start, end, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.identifier = identifier;
    this.typeBound = typeBound;
  }

  public TypeParameter(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                       Collection<Annotation> annotationList,
                       String identifier,
                       TypeBound typeBound) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.identifier = identifier;
    this.typeBound = typeBound;
  }
}
