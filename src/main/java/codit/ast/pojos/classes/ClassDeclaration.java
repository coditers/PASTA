package codit.ast.pojos.classes;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ClassDeclaration extends AstNode {
  public ClassDeclaration(Range range, AstNode parent) {
    super(range, parent);
  }

  public ClassDeclaration(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ClassDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
