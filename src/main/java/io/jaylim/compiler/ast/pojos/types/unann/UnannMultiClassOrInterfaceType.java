package io.jaylim.compiler.ast.pojos.types.unann;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.types.Type;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannMultiClassOrInterfaceType extends Type {

  public UnannMultiClassOrInterfaceType(Range range, AstNode parent) {
    super(range, parent);
  }

  public UnannMultiClassOrInterfaceType(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public UnannMultiClassOrInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
