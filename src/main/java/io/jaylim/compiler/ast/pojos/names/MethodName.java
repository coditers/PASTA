package io.jaylim.compiler.ast.pojos.names;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MethodName extends Name {
  public MethodName(Range range, AstNode parent, String identifier) {
    super(range, parent, identifier);
  }

  public MethodName(Position start, Position end, AstNode parent, String identifier) {
    super(start, end, parent, identifier);
  }

  public MethodName(int startLine, int startCol, int endLine, int endCol, AstNode parent, String identifier) {
    super(startLine, startCol, endLine, endCol, parent, identifier);
  }


}
