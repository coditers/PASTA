package io.jaylim.compiler.ast.pojos.types;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class TypeArgumentsOrDiamond extends AstNode {

  public TypeArgumentsOrDiamond(Range range, AstNode parent) {
    super(range, parent);
  }

  public TypeArgumentsOrDiamond(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public TypeArgumentsOrDiamond(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
