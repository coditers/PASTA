package io.jaylim.compiler.ast.pojos.expressions.primaries.arraycreationexpression;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.expressions.Expression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class DimExpr extends AstNode {

  private final List<Annotation> annotationList;
  private final Expression expression;

  public DimExpr(Range range, AstNode parent, List<Annotation> annotationList, Expression expression) {
    super(range, parent);
    this.annotationList = annotationList;
    this.expression = expression;
  }

  public DimExpr(Position start, Position end, AstNode parent, List<Annotation> annotationList, Expression expression) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.expression = expression;
  }

  public DimExpr(int startLine, int startCol, int endLine, int endCol, AstNode parent, List<Annotation> annotationList, Expression expression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.expression = expression;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }
}
