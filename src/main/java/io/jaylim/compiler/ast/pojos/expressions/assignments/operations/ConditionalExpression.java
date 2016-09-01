package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.assignments.AssignmentExpression;
import io.jaylim.compiler.ast.pojos.interfaces.ElementValue;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ConditionalExpression extends AssignmentExpression implements ElementValue {

  public ConditionalExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public ConditionalExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ConditionalExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
