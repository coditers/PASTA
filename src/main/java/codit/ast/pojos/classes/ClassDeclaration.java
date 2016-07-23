package codit.ast.pojos.classes;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ClassDeclaration extends AstNode {
  public ClassDeclaration(Range range) {
    super(range);
  }

  public ClassDeclaration(Position start, Position end) {
    super(start, end);
  }

  public ClassDeclaration(int startLine, int startCol, int endLine, int endCol) {
    super(startLine, startCol, endLine, endCol);
  }
}
