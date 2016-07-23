package codit.ast.pojos.packages;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class TypeDeclaration extends AstNode {
  public TypeDeclaration(Range range) {
    super(range);
  }

  public TypeDeclaration(Position start, Position end) {
    super(start, end);
  }

  public TypeDeclaration(int startLine, int startCol, int endLine, int endCol) {
    super(startLine, startCol, endLine, endCol);
  }
}
