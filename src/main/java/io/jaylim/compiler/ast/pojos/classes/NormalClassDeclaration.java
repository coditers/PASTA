package io.jaylim.compiler.ast.pojos.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.types.ClassType;
import io.jaylim.compiler.ast.pojos.types.InterfaceType;
import io.jaylim.compiler.ast.pojos.types.TypeParameter;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class NormalClassDeclaration extends ClassDeclaration {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final String identifier;
  private final List<TypeParameter> typeParameterList;

  private final ClassType superClass;
  private final List<InterfaceType> superInterfaceList;

  private final List<ClassBodyDeclaration> classBodyDeclarationList;

  public NormalClassDeclaration(Range range, AstNode parent, 
                                Collection<Annotation> annotationList, 
                                int modifiers, 
                                String identifier, 
                                Collection<TypeParameter> typeParameterList, 
                                ClassType superClass, 
                                Collection<InterfaceType> superInterfaceList, 
                                Collection<ClassBodyDeclaration> classBodyDeclarationList) {
    super(range, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.typeParameterList = new ArrayList<>(typeParameterList);
    this.superClass = superClass;
    this.superInterfaceList = new ArrayList<>(superInterfaceList);
    this.classBodyDeclarationList = new ArrayList<>(classBodyDeclarationList);
  }

  public NormalClassDeclaration(Position start, Position end, AstNode parent,
                                Collection<Annotation> annotationList,
                                int modifiers,
                                String identifier,
                                Collection<TypeParameter> typeParameterList,
                                ClassType superClass,
                                Collection<InterfaceType> superInterfaceList,
                                Collection<ClassBodyDeclaration> classBodyDeclarationList) {
    super(start, end, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.typeParameterList = new ArrayList<>(typeParameterList);
    this.superClass = superClass;
    this.superInterfaceList = new ArrayList<>(superInterfaceList);
    this.classBodyDeclarationList = new ArrayList<>(classBodyDeclarationList);
  }

  public NormalClassDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                Collection<Annotation> annotationList,
                                int modifiers,
                                String identifier,
                                Collection<TypeParameter> typeParameterList,
                                ClassType superClass,
                                Collection<InterfaceType> superInterfaceList,
                                Collection<ClassBodyDeclaration> classBodyDeclarationList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.typeParameterList = new ArrayList<>(typeParameterList);
    this.superClass = superClass;
    this.superInterfaceList = new ArrayList<>(superInterfaceList);
    this.classBodyDeclarationList = new ArrayList<>(classBodyDeclarationList);
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

  @JsonProperty("TypeParameterList")
  public List<TypeParameter> getTypeParameterList() {
    return typeParameterList;
  }

  @JsonProperty("SuperClass")
  public ClassType getSuperClass() {
    return superClass;
  }

  @JsonProperty("SuperInterfaceList")
  public List<InterfaceType> getSuperInterfaceList() {
    return superInterfaceList;
  }

  @JsonProperty("ClassBodyDeclarationList")
  public List<ClassBodyDeclaration> getClassBodyDeclarationList() {
    return classBodyDeclarationList;
  }
}
