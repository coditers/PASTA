package codit.ast.pojos.types;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ArrayType extends ReferenceType {

  private final Arrayable arrayable;
  private final Dims dims;

  public ArrayType(Range range, AstNode parent,
                   Arrayable arrayable,
                   Dims dims) {
    super(range, parent);
    this.arrayable = arrayable;
    this.dims = dims;
  }

  public ArrayType(Position start, Position end, AstNode parent,
                   Arrayable arrayable,
                   Dims dims) {
    super(start, end, parent);
    this.arrayable = arrayable;
    this.dims = dims;
  }

  public ArrayType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                   Arrayable arrayable,
                   Dims dims) {
    super(startLine, startCol, endLine, endCol, parent);
    this.arrayable = arrayable;
    this.dims = dims;
  }
}
