package codit.ast.pojos.classes.members;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ClassMemberDeclaration extends AstNode {

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
