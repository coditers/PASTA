package io.jaylim.compiler.ast.pojos.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeArgument extends AstNode {

  private final Arguable arguable;

  public TypeArgument(Range range, AstNode parent, Arguable arguable) {
    super(range, parent);
    this.arguable = arguable;
  }

  public TypeArgument(Position start, Position end, AstNode parent, Arguable arguable) {
    super(start, end, parent);
    this.arguable = arguable;
  }

  public TypeArgument(int startLine, int startCol, int endLine, int endCol, AstNode parent, Arguable arguable) {
    super(startLine, startCol, endLine, endCol, parent);
    this.arguable = arguable;
  }

  @JsonProperty("Arguable")
  public Arguable getArguable() {
    return arguable;
  }
}
