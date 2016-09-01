package io.jaylim.compiler.ast.pojos.expressions.assignments;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class AssignmentExpression extends Expression {
  public AssignmentExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public AssignmentExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public AssignmentExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
