package io.jaylim.compiler.ast.pojos.expressions.primaries.arrayaccess;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.primaries.PrimaryExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ArrayAccess extends PrimaryExpression {

  public ArrayAccess(Range range, AstNode parent) {
    super(range, parent);
  }

  public ArrayAccess(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ArrayAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
