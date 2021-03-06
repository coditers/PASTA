package io.jaylim.compiler.ast.pojos.parameters;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jay Lim
 * @date 8/25/2016
 */
public abstract class FormalParameterList extends AstNode {

  public FormalParameterList(Range range, AstNode parent) {
    super(range, parent);
  }

  public FormalParameterList(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public FormalParameterList(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
