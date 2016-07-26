package codit.ast.pojos.classes.members;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.classes.ClassBodyDeclaration;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ClassMemberDeclaration extends ClassBodyDeclaration {

  private final ClassMemberable classMemberable;

  public ClassMemberDeclaration(Range range, AstNode parent,
                                ClassMemberable classMemberable) {
    super(range, parent);
    this.classMemberable = classMemberable;
  }

  public ClassMemberDeclaration(Position start, Position end, AstNode parent,
                                ClassMemberable classMemberable) {
    super(start, end, parent);
    this.classMemberable = classMemberable;
  }

  public ClassMemberDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                ClassMemberable classMemberable) {
    super(startLine, startCol, endLine, endCol, parent);
    this.classMemberable = classMemberable;
  }
}
