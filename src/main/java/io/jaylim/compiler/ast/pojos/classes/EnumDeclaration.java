package io.jaylim.compiler.ast.pojos.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.types.InterfaceType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class EnumDeclaration extends ClassDeclaration {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final String identifier;

  private final List<InterfaceType> superInterfaceList;

  private final EnumBody enumBody;

  public EnumDeclaration(Range range, AstNode parent,
                         List<Annotation> annotationList,
                         int modifiers,
                         String identifier,
                         List<InterfaceType> superInterfaceList,
                         EnumBody enumBody) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.superInterfaceList = superInterfaceList;
    this.enumBody = enumBody;
  }

  public EnumDeclaration(Position start, Position end, AstNode parent,
                         List<Annotation> annotationList,
                         int modifiers,
                         String identifier,
                         List<InterfaceType> superInterfaceList,
                         EnumBody enumBody) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.superInterfaceList = superInterfaceList;
    this.enumBody = enumBody;
  }

  public EnumDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                         List<Annotation> annotationList,
                         int modifiers,
                         String identifier,
                         List<InterfaceType> superInterfaceList,
                         EnumBody enumBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.superInterfaceList = superInterfaceList;
    this.enumBody = enumBody;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Modifiers")
  public int getModifiers() {
    return modifiers;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty("SuperInterfaceList")
  public List<InterfaceType> getSuperInterfaceList() {
    return superInterfaceList;
  }

  @JsonProperty("EnumBody")
  public EnumBody getEnumBody() {
    return enumBody;
  }
}
