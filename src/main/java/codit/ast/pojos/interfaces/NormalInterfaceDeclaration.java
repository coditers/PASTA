package codit.ast.pojos.interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.types.InterfaceType;
import codit.ast.pojos.types.TypeParameter;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class NormalInterfaceDeclaration extends InterfaceDeclaration {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final String identifier;

  private final List<TypeParameter> typeParameterList;

  private final List<InterfaceType> interfaceTypeList;

  private final List<InterfaceMemberable> interfaceBody;

  public NormalInterfaceDeclaration(Range range, AstNode parent,
                                    List<Annotation> annotationList,
                                    int modifiers,
                                    String identifier,
                                    List<TypeParameter> typeParameterList,
                                    List<InterfaceType> interfaceTypeList,
                                    List<InterfaceMemberable> interfaceBody) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.typeParameterList = typeParameterList;
    this.interfaceTypeList = interfaceTypeList;
    this.interfaceBody = interfaceBody;
  }

  public NormalInterfaceDeclaration(Position start, Position end, AstNode parent,
                                    List<Annotation> annotationList,
                                    int modifiers,
                                    String identifier,
                                    List<TypeParameter> typeParameterList,
                                    List<InterfaceType> interfaceTypeList,
                                    List<InterfaceMemberable> interfaceBody) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.typeParameterList = typeParameterList;
    this.interfaceTypeList = interfaceTypeList;
    this.interfaceBody = interfaceBody;
  }

  public NormalInterfaceDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                    List<Annotation> annotationList,
                                    int modifiers,
                                    String identifier,
                                    List<TypeParameter> typeParameterList,
                                    List<InterfaceType> interfaceTypeList,
                                    List<InterfaceMemberable> interfaceBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.identifier = identifier;
    this.typeParameterList = typeParameterList;
    this.interfaceTypeList = interfaceTypeList;
    this.interfaceBody = interfaceBody;
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

  @JsonProperty("InterfaceTypeList")
  public List<InterfaceType> getInterfaceTypeList() {
    return interfaceTypeList;
  }

  @JsonProperty("InterfaceBody")
  public List<InterfaceMemberable> getInterfaceBody() {
    return interfaceBody;
  }
}
