package codit.ast.pojos.packages;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PackageModifier extends AstNode {

  Annotation annotation;

  public PackageModifier(Range range, AstNode parent, Annotation annotation) {
    super(range, parent);
    this.annotation = annotation;
  }

  public PackageModifier(Position start, Position end, AstNode parent, Annotation annotation) {
    super(start, end, parent);
    this.annotation = annotation;
  }

  public PackageModifier(int startLine, int startCol, int endLine, int endCol, AstNode parent, Annotation annotation) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotation = annotation;
  }
}
