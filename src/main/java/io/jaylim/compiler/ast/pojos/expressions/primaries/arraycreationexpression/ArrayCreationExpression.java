package io.jaylim.compiler.ast.pojos.expressions.primaries.arraycreationexpression;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ArrayCreationExpression extends AstNode {

  public ArrayCreationExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public ArrayCreationExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ArrayCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
