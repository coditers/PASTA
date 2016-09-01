package io.jaylim.compiler.ast.pojos.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LocalVariableDeclarationStatement extends AstNode implements InBlockStatement {

  private final LocalVariableDeclaration localVariableDeclaration;

  public LocalVariableDeclarationStatement(Range range, AstNode parent, LocalVariableDeclaration localVariableDeclaration) {
    super(range, parent);
    this.localVariableDeclaration = localVariableDeclaration;
  }

  public LocalVariableDeclarationStatement(Position start, Position end, AstNode parent, LocalVariableDeclaration localVariableDeclaration) {
    super(start, end, parent);
    this.localVariableDeclaration = localVariableDeclaration;
  }

  public LocalVariableDeclarationStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent, LocalVariableDeclaration localVariableDeclaration) {
    super(startLine, startCol, endLine, endCol, parent);
    this.localVariableDeclaration = localVariableDeclaration;
  }

  @JsonProperty("LocalVariableDeclaration")
  public LocalVariableDeclaration getLocalVariableDeclaration() {
    return localVariableDeclaration;
  }
}
