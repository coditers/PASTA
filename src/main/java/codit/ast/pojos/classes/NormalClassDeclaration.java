package codit.ast.pojos.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.types.ClassType;
import codit.ast.pojos.types.InterfaceType;
import codit.ast.pojos.types.TypeParameter;

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
}
