package codit.ast.pojos.types;

import java.util.Collections;
import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnitClassOrInterfaceType extends Type {

  private final boolean isInterface;

  private final List<Annotation> annotationList;
  private final String identifier;
  private final List<TypeArgument> typeArgumentList;

  public UnitClassOrInterfaceType(Range range, AstNode parent,
                                  boolean isInterface,
                                  List<Annotation> annotationList,
                                  String identifier,
                                  List<TypeArgument> typeArgumentList) {
    super(range, parent);
    this.isInterface = isInterface;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  public UnitClassOrInterfaceType(Position start, Position end, AstNode parent,
                                  boolean isInterface,
                                  List<Annotation> annotationList,
                                  String identifier,
                                  List<TypeArgument> typeArgumentList) {
    super(start, end, parent);
    this.isInterface = isInterface;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  public UnitClassOrInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                  boolean isInterface,
                                  List<Annotation> annotationList,
                                  String identifier,
                                  List<TypeArgument> typeArgumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.isInterface = isInterface;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  public boolean isInterface() {
    return isInterface;
  }

  public List<Annotation> getAnnotationList() {
    return Collections.unmodifiableList(annotationList);
  }

  public String getIdentifier() {
    return identifier;
  }

  public List<TypeArgument> getTypeArgumentList() {
    return Collections.unmodifiableList(typeArgumentList);
  }
}
