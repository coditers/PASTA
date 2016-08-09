package codit.ast.pojos.types;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InterfaceType extends MultiClassOrInterfaceType {

  private final ClassType classType;

  public InterfaceType(Range range, AstNode parent, ClassType classType) {
    super(range, parent);
    this.classType = classType;
  }

  public InterfaceType(Position start, Position end, AstNode parent, ClassType classType) {
    super(start, end, parent);
    this.classType = classType;
  }

  public InterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent, ClassType classType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.classType = classType;
  }
}
