package codit.ast.pojos.types.unann;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.types.TypeArgument;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannClassType extends UnannMultiClassOrInterfaceType {

  private final UnannClassOrInterfaceType unannClassOrInterfaceType;

  private final List<Annotation> annotationList;

  private final String identifier;

  private final List<TypeArgument> typeArgumentList;

  public UnannClassType(Range range, AstNode parent,
                        UnannClassOrInterfaceType unannClassOrInterfaceType,
                        List<Annotation> annotationList,
                        String identifier,
                        List<TypeArgument> typeArgumentList) {
    super(range, parent);
    this.unannClassOrInterfaceType = unannClassOrInterfaceType;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  public UnannClassType(Position start, Position end, AstNode parent,
                        UnannClassOrInterfaceType unannClassOrInterfaceType,
                        List<Annotation> annotationList,
                        String identifier,
                        List<TypeArgument> typeArgumentList) {
    super(start, end, parent);
    this.unannClassOrInterfaceType = unannClassOrInterfaceType;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  public UnannClassType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                        UnannClassOrInterfaceType unannClassOrInterfaceType,
                        List<Annotation> annotationList,
                        String identifier,
                        List<TypeArgument> typeArgumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unannClassOrInterfaceType = unannClassOrInterfaceType;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }
}
