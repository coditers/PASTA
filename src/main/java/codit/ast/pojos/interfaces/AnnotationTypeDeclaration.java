package codit.ast.pojos.interfaces;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class AnnotationTypeDeclaration extends InterfaceDeclaration {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final String identifier;

  private final List<AnnotationTypeMemberable> annotationTypeBody;

  public AnnotationTypeDeclaration(Range range, AstNode parent,
                                   List<Annotation> annotationList,
                                   int modifiers,
                                   String identifier,
                                   List<AnnotationTypeMemberable> annotationTypeBody) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.annotationTypeBody = annotationTypeBody;
  }

  public AnnotationTypeDeclaration(Position start, Position end, AstNode parent,
                                   List<Annotation> annotationList,
                                   int modifiers,
                                   String identifier,
                                   List<AnnotationTypeMemberable> annotationTypeBody) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.annotationTypeBody = annotationTypeBody;
  }

  public AnnotationTypeDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   List<Annotation> annotationList,
                                   int modifiers,
                                   String identifier,
                                   List<AnnotationTypeMemberable> annotationTypeBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.annotationTypeBody = annotationTypeBody;
  }
}
