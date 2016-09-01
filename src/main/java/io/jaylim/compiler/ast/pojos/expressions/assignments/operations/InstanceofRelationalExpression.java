package io.jaylim.compiler.ast.pojos.expressions.assignments.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.types.ReferenceType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InstanceofRelationalExpression extends RelationalExpression {
  private final RelationalExpression relationalExpression;
  private final ReferenceType referenceType;

  public InstanceofRelationalExpression(Range range, AstNode parent,
                                        RelationalExpression relationalExpression,
                                        ReferenceType referenceType) {
    super(range, parent);
    this.relationalExpression = relationalExpression;
    this.referenceType = referenceType;
  }

  public InstanceofRelationalExpression(Position start, Position end, AstNode parent,
                                        RelationalExpression relationalExpression,
                                        ReferenceType referenceType) {
    super(start, end, parent);
    this.relationalExpression = relationalExpression;
    this.referenceType = referenceType;
  }

  public InstanceofRelationalExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                        RelationalExpression relationalExpression,
                                        ReferenceType referenceType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.relationalExpression = relationalExpression;
    this.referenceType = referenceType;
  }

  @JsonProperty("RelationalExpression")
  public RelationalExpression getRelationalExpression() {
    return relationalExpression;
  }

  @JsonProperty("ReferenceType")
  public ReferenceType getReferenceType() {
    return referenceType;
  }
}
