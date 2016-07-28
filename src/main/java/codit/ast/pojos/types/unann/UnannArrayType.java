package codit.ast.pojos.types.unann;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.types.Dims;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannArrayType extends UnannReferenceType {

  private final UnannArrayable unannArrayable;

  private final Dims dims;

  public UnannArrayType(Range range, AstNode parent, UnannArrayable unannArrayable, Dims dims) {
    super(range, parent);
    this.unannArrayable = unannArrayable;
    this.dims = dims;
  }

  public UnannArrayType(Position start, Position end, AstNode parent, UnannArrayable unannArrayable, Dims dims) {
    super(start, end, parent);
    this.unannArrayable = unannArrayable;
    this.dims = dims;
  }

  public UnannArrayType(int startLine, int startCol, int endLine, int endCol, AstNode parent, UnannArrayable unannArrayable, Dims dims) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unannArrayable = unannArrayable;
    this.dims = dims;
  }
}
