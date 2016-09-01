package io.jaylim.compiler.ast.pojos.classes.constructors;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.blocks.BlockStatements;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ConstructorBody extends AstNode {

  private final ExplicitConstructorInvocation explicitConstructorInvocation;

  private final BlockStatements blockStatements;

  public ConstructorBody(Range range, AstNode parent,
                         ExplicitConstructorInvocation explicitConstructorInvocation,
                         BlockStatements blockStatements) {
    super(range, parent);
    this.explicitConstructorInvocation = explicitConstructorInvocation;
    this.blockStatements = blockStatements;
  }

  public ConstructorBody(Position start, Position end, AstNode parent,
                         ExplicitConstructorInvocation explicitConstructorInvocation,
                         BlockStatements blockStatements) {
    super(start, end, parent);
    this.explicitConstructorInvocation = explicitConstructorInvocation;
    this.blockStatements = blockStatements;
  }

  public ConstructorBody(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                         ExplicitConstructorInvocation explicitConstructorInvocation,
                         BlockStatements blockStatements) {
    super(startLine, startCol, endLine, endCol, parent);
    this.explicitConstructorInvocation = explicitConstructorInvocation;
    this.blockStatements = blockStatements;
  }

  @JsonProperty("ExplicitConstructorInvocation")
  public ExplicitConstructorInvocation getExplicitConstructorInvocation() {
    return explicitConstructorInvocation;
  }

  @JsonProperty("BlockStatements")
  public BlockStatements getBlockStatements() {
    return blockStatements;
  }
}
