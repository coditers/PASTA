package codit.ast.pojos.types.unann;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.types.PrimitiveType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannPrimitiveType extends UnannType implements UnannArrayable {

  private final PrimitiveType.Primitive type;

  public UnannPrimitiveType(Range range,
                            AstNode parent,
                            PrimitiveType.Primitive type) {
    super(range, parent);
    this.type = type;
  }

  public UnannPrimitiveType(Position start, Position end,
                            AstNode parent,
                            PrimitiveType.Primitive type) {
    super(start, end, parent);
    this.type = type;
  }

  public UnannPrimitiveType(int startLine, int startCol, int endLine, int endCol,
                            AstNode parent,
                            PrimitiveType.Primitive type) {
    super(startLine, startCol, endLine, endCol, parent);
    this.type = type;
  }
}
