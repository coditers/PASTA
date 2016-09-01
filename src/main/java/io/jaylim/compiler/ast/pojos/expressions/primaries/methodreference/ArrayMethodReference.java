package io.jaylim.compiler.ast.pojos.expressions.primaries.methodreference;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.types.ArrayType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ArrayMethodReference extends MethodReference
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final ArrayType arrayType;

  public ArrayMethodReference(Range range, AstNode parent,
                              ArrayType arrayType) {
    super(range, parent);
    this.arrayType = arrayType;
  }

  public ArrayMethodReference(Position start, Position end, AstNode parent,
                              ArrayType arrayType) {
    super(start, end, parent);
    this.arrayType = arrayType;
  }

  public ArrayMethodReference(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                              ArrayType arrayType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.arrayType = arrayType;
  }

  @JsonProperty("ArrayType")
  public ArrayType getArrayType() {
    return arrayType;
  }
}
