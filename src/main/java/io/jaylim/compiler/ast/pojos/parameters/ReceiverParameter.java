package io.jaylim.compiler.ast.pojos.parameters;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.types.unann.UnannType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ReceiverParameter extends Parameter {

  private final List<Annotation> annotationList;

  private final UnannType unannType;

  private final String identifier;

  public ReceiverParameter(Range range, AstNode parent,
                           List<Annotation> annotationList,
                           UnannType unannType,
                           String identifier) {
    super(range, parent);
    this.annotationList = annotationList;
    this.unannType = unannType;
    this.identifier = identifier;
  }

  public ReceiverParameter(Position start, Position end, AstNode parent,
                           List<Annotation> annotationList,
                           UnannType unannType,
                           String identifier) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.unannType = unannType;
    this.identifier = identifier;
  }

  public ReceiverParameter(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                           List<Annotation> annotationList,
                           UnannType unannType,
                           String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.unannType = unannType;
    this.identifier = identifier;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("UnannType")
  public UnannType getUnannType() {
    return unannType;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }
}
