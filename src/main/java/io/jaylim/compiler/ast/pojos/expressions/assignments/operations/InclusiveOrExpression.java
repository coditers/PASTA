package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class InclusiveOrExpression extends ConditionalAndExpression {
  public InclusiveOrExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public InclusiveOrExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public InclusiveOrExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}