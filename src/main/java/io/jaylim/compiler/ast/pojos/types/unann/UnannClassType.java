package io.jaylim.compiler.ast.pojos.types.unann;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.types.TypeArgument;

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

  @JsonProperty("UnannClassOrInterfaceType")
  public UnannClassOrInterfaceType getUnannClassOrInterfaceType() {
    return unannClassOrInterfaceType;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty("TypeArgumentList")
  public List<TypeArgument> getTypeArgumentList() {
    return typeArgumentList;
  }
}
