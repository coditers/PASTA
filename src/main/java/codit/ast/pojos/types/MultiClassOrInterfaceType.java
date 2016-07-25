package codit.ast.pojos.types;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MultiClassOrInterfaceType extends Type {

  public MultiClassOrInterfaceType(Range range, AstNode parent) {
    super(range, parent);
  }

  public MultiClassOrInterfaceType(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public MultiClassOrInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
