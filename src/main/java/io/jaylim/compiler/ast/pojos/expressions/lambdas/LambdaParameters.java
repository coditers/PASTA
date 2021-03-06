package io.jaylim.compiler.ast.pojos.expressions.lambdas;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class LambdaParameters extends AstNode {

  public LambdaParameters(Range range, AstNode parent) {
    super(range, parent);
  }

  public LambdaParameters(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public LambdaParameters(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
