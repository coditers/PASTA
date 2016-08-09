package codit.ast.pojos.annotations;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.interfaces.InterfaceDeclaration;

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
