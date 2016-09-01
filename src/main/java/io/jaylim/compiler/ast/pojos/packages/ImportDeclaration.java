package io.jaylim.compiler.ast.pojos.packages;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ImportDeclaration extends AstNode {
  public ImportDeclaration(Range range, AstNode parent) {
    super(range, parent);
  }

  public ImportDeclaration(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ImportDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
