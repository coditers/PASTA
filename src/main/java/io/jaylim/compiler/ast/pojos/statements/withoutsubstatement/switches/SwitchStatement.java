package io.jaylim.compiler.ast.pojos.statements.withoutsubstatement.switches;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SwitchStatement extends AstNode implements StatementWithoutTrailingSubstatement {

  private final Expression expression;
  private final SwitchBlock switchBlock;


  public SwitchStatement(Range range, AstNode parent,
                         Expression expression,
                         SwitchBlock switchBlock) {
    super(range, parent);
    this.expression = expression;
    this.switchBlock = switchBlock;
  }

  public SwitchStatement(Position start, Position end, AstNode parent,
                         Expression expression,
                         SwitchBlock switchBlock) {
    super(start, end, parent);
    this.expression = expression;
    this.switchBlock = switchBlock;
  }

  public SwitchStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                         Expression expression,
                         SwitchBlock switchBlock) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
    this.switchBlock = switchBlock;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }

  @JsonProperty("SwitchBlock")
  public SwitchBlock getSwitchBlock() {
    return switchBlock;
  }
}

