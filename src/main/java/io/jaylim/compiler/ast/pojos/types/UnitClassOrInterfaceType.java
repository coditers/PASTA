package io.jaylim.compiler.ast.pojos.types;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnitClassOrInterfaceType extends Type {


  public UnitClassOrInterfaceType(Range range, AstNode parent) {
    super(range, parent);
  }

  public UnitClassOrInterfaceType(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public UnitClassOrInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
