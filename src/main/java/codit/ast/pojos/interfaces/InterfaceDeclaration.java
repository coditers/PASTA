package codit.ast.pojos.interfaces;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InterfaceDeclaration extends AstNode {

  public InterfaceDeclaration(Range range) {
    super(range);
  }

  public InterfaceDeclaration(Position start, Position end) {
    super(start, end);
  }

  public InterfaceDeclaration(int startLine, int startCol, int endLine, int endCol) {
    super(startLine, startCol, endLine, endCol);
  }
}
