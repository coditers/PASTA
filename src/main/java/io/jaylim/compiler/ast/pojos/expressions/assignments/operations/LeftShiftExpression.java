package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LeftShiftExpression extends ShiftExpression {
  private final ShiftExpression shiftExpression;
  private final AdditiveExpression additiveExpression;

  public LeftShiftExpression(Range range, AstNode parent, ShiftExpression shiftExpression, AdditiveExpression additiveExpression) {
    super(range, parent);
    this.shiftExpression = shiftExpression;
    this.additiveExpression = additiveExpression;
  }

  public LeftShiftExpression(Position start, Position end, AstNode parent, ShiftExpression shiftExpression, AdditiveExpression additiveExpression) {
    super(start, end, parent);
    this.shiftExpression = shiftExpression;
    this.additiveExpression = additiveExpression;
  }

  public LeftShiftExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, ShiftExpression shiftExpression, AdditiveExpression additiveExpression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.shiftExpression = shiftExpression;
    this.additiveExpression = additiveExpression;
  }

  @JsonProperty("ShiftExpression")
  public ShiftExpression getShiftExpression() {
    return shiftExpression;
  }

  @JsonProperty("AdditiveExpression")
  public AdditiveExpression getAdditiveExpression() {
    return additiveExpression;
  }
}
