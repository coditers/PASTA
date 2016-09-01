package io.jaylim.compiler.ast.pojos.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

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

  @JsonProperty("Arrayable")
  public Arrayable getArrayable() {
    return arrayable;
  }

  @JsonProperty("Dims")
  public Dims getDims() {
    return dims;
  }
}
