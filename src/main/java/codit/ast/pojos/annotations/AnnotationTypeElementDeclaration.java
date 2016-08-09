package codit.ast.pojos.annotations;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.interfaces.ElementValue;
import codit.ast.pojos.types.Dims;
import codit.ast.pojos.types.unann.UnannType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class AnnotationTypeElementDeclaration extends AstNode implements AnnotationTypeMemberable {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final UnannType unannType;

  private final String identifier;

  private final Dims dims;

  private final ElementValue defaultValue;

  public AnnotationTypeElementDeclaration(Range range, AstNode parent,
                                          List<Annotation> annotationList,
                                          int modifiers,
                                          UnannType unannType,
                                          String identifier,
                                          Dims dims,
                                          ElementValue defaultValue) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.identifier = identifier;
    this.dims = dims;
    this.defaultValue = defaultValue;
  }

  public AnnotationTypeElementDeclaration(Position start, Position end, AstNode parent,
                                          List<Annotation> annotationList,
                                          int modifiers,
                                          UnannType unannType,
                                          String identifier,
                                          Dims dims,
                                          ElementValue defaultValue) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.identifier = identifier;
    this.dims = dims;
    this.defaultValue = defaultValue;
  }

  public AnnotationTypeElementDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                          List<Annotation> annotationList,
                                          int modifiers,
                                          UnannType unannType,
                                          String identifier,
                                          Dims dims,
                                          ElementValue defaultValue) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.identifier = identifier;
    this.dims = dims;
    this.defaultValue = defaultValue;
  }
}
