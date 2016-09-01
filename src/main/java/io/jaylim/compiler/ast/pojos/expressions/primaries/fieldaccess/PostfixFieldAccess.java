package io.jaylim.compiler.ast.pojos.expressions.primaries.fieldaccess;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PostfixFieldAccess extends FieldAccess
    implements DefaultArrayLfPrimary, LfnoArrayLfPrimary {

  private final String identifier;

  public PostfixFieldAccess(Range range, AstNode parent, String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public PostfixFieldAccess(Position start, Position end, AstNode parent, String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public PostfixFieldAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent, String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }
}
