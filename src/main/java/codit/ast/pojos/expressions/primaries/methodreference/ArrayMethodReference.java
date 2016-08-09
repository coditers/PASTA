package codit.ast.pojos.expressions.primaries.methodreference;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.types.ArrayType;

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
}
