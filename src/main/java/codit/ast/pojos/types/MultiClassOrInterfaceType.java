package codit.ast.pojos.types;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MultiClassOrInterfaceType extends UnitClassOrInterfaceType {

  private final ClassOrInterfaceType classOrInterfaceType;

  public MultiClassOrInterfaceType(Range range, AstNode parent,
                                   boolean isInterface,
                                   List<Annotation> annotationList,
                                   String identifier,
                                   List<TypeArgument> typeArgumentList,
                                   ClassOrInterfaceType classOrInterfaceType) {
    super(range, parent, isInterface, annotationList, identifier, typeArgumentList);
    this.classOrInterfaceType = classOrInterfaceType;
  }

  public MultiClassOrInterfaceType(Position start, Position end, AstNode parent,
                                   boolean isInterface,
                                   List<Annotation> annotationList,
                                   String identifier,
                                   List<TypeArgument> typeArgumentList,
                                   ClassOrInterfaceType classOrInterfaceType) {
    super(start, end, parent, isInterface, annotationList, identifier, typeArgumentList);
    this.classOrInterfaceType = classOrInterfaceType;
  }

  public MultiClassOrInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   boolean isInterface,
                                   List<Annotation> annotationList,
                                   String identifier,
                                   List<TypeArgument> typeArgumentList,
                                   ClassOrInterfaceType classOrInterfaceType) {
    super(startLine, startCol, endLine, endCol, parent, isInterface, annotationList, identifier, typeArgumentList);
    this.classOrInterfaceType = classOrInterfaceType;
  }
}
