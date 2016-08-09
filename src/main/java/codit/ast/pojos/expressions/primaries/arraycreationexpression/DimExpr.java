package codit.ast.pojos.expressions.primaries.arraycreationexpression;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.expressions.Expression;

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
}
