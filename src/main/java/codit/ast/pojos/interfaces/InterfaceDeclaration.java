package codit.ast.pojos.interfaces;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.AnnotationTypeMemberable;
import codit.ast.pojos.classes.members.ClassMemberable;
import codit.ast.pojos.packages.TypeDeclaration;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InterfaceDeclaration extends TypeDeclaration implements ClassMemberable, InterfaceMemberable, AnnotationTypeMemberable {
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
