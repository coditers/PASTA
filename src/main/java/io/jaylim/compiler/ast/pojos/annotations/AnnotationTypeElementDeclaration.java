package io.jaylim.compiler.ast.pojos.annotations;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.interfaces.ElementValue;
import io.jaylim.compiler.ast.pojos.types.Dims;
import io.jaylim.compiler.ast.pojos.types.unann.UnannType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class AnnotationTypeElementDeclaration extends AstNode implements AnnotationTypeMemberable {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final UnannType unannType;

  private final String identifier;

  private final Dims dims;

  private final ElementValue defaultValue;

  public AnnotationTypeElementDeclaration(Range range, AstNode parent,
                                          List<Annotation> annotationList,
                                          int modifiers,
                                          UnannType unannType,
                                          String identifier,
                                          Dims dims,
                                          ElementValue defaultValue) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.identifier = identifier;
    this.dims = dims;
    this.defaultValue = defaultValue;
  }

  public AnnotationTypeElementDeclaration(Position start, Position end, AstNode parent,
                                          List<Annotation> annotationList,
                                          int modifiers,
                                          UnannType unannType,
                                          String identifier,
                                          Dims dims,
                                          ElementValue defaultValue) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.identifier = identifier;
    this.dims = dims;
    this.defaultValue = defaultValue;
  }

  public AnnotationTypeElementDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                          List<Annotation> annotationList,
                                          int modifiers,
                                          UnannType unannType,
                                          String identifier,
                                          Dims dims,
                                          ElementValue defaultValue) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.identifier = identifier;
    this.dims = dims;
    this.defaultValue = defaultValue;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Modifiers")
  public int getModifiers() {
    return modifiers;
  }

  @JsonProperty("UnannType")
  public UnannType getUnannType() {
    return unannType;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty("Dims")
  public Dims getDims() {
    return dims;
  }

  @JsonProperty("DefaultValue")
  public ElementValue getDefaultValue() {
    return defaultValue;
  }
}
