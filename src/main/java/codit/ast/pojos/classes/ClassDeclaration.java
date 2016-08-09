package codit.ast.pojos.classes;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.blocks.InBlockStatement;
import codit.ast.pojos.classes.members.ClassMemberable;
import codit.ast.pojos.annotations.AnnotationTypeMemberable;
import codit.ast.pojos.interfaces.InterfaceMemberable;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ClassDeclaration extends AstNode implements ClassMemberable, InterfaceMemberable, AnnotationTypeMemberable, InBlockStatement {
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
