package codit.ast.pojos.types.unann;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannInterfaceType extends UnannMultiClassOrInterfaceType {

  private final UnannClassType unannClassType;

  public UnannInterfaceType(Range range, AstNode parent,
                            UnannClassType unannClassType) {
    super(range, parent);
    this.unannClassType = unannClassType;
  }

  public UnannInterfaceType(Position start, Position end, AstNode parent,
                            UnannClassType unannClassType) {
    super(start, end, parent);
    this.unannClassType = unannClassType;
  }

  public UnannInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                            UnannClassType unannClassType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unannClassType = unannClassType;
  }
}
