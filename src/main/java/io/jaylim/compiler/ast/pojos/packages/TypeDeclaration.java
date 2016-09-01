package io.jaylim.compiler.ast.pojos.packages;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class TypeDeclaration extends AstNode {
  public TypeDeclaration(Range range, AstNode parent) {
    super(range, parent);
  }

  public TypeDeclaration(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public TypeDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
