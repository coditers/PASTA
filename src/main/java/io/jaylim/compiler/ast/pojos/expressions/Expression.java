package io.jaylim.compiler.ast.pojos.expressions;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.lambdas.LambdaBody;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class Expression extends AstNode implements LambdaBody {
  public Expression(Range range, AstNode parent) {
    super(range, parent);
  }

  public Expression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public Expression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
