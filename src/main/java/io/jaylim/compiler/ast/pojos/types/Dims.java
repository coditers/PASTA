package io.jaylim.compiler.ast.pojos.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Dims extends AstNode {
  private final List<List<Annotation>> annotationListList;

  public Dims(Range range, AstNode parent,
              Collection<List<Annotation>> annotationListList) {
    super(range, parent);
    this.annotationListList = new ArrayList<>(annotationListList);
  }

  public Dims(Position start, Position end, AstNode parent,
              Collection<List<Annotation>> annotationListList) {
    super(start, end, parent);
    this.annotationListList = new ArrayList<>(annotationListList);
  }

  public Dims(int startLine, int startCol, int endLine, int endCol, AstNode parent,
              Collection<List<Annotation>> annotationListList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationListList = new ArrayList<>(annotationListList);
  }

  @JsonProperty("AnnotationListList")
  public List<List<Annotation>> getAnnotationListList() {
    return annotationListList;
  }
}
