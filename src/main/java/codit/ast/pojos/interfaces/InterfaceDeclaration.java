package codit.ast.pojos.interfaces;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.classes.members.ClassMemberable;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InterfaceDeclaration extends AstNode implements ClassMemberable {
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
