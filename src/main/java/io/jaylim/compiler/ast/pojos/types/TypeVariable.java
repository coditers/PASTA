package io.jaylim.compiler.ast.pojos.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.types.exceptions.Exceptionable;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeVariable extends ReferenceType implements Arrayable, Exceptionable {

  private final List<Annotation> annotationList;
  private final String identifier;

  public TypeVariable(Range range, AstNode parent, List<Annotation> annotationList, String identifier) {
    super(range, parent);
    this.annotationList = annotationList;
    this.identifier = identifier;
  }

  public TypeVariable(Position start, Position end, AstNode parent, List<Annotation> annotationList, String identifier) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.identifier = identifier;
  }

  public TypeVariable(int startLine, int startCol, int endLine, int endCol, AstNode parent, List<Annotation> annotationList, String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.identifier = identifier;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

}
