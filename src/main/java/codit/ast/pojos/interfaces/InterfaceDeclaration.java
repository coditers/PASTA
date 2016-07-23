package codit.ast.pojos.interfaces;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InterfaceDeclaration extends AstNode {
  public InterfaceDeclaration(Range range, AstNode parent) {
    super(range, parent);
  }

  public InterfaceDeclaration(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public InterfaceDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
