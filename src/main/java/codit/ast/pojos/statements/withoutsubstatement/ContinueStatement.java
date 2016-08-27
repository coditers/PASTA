package codit.ast.pojos.statements.withoutsubstatement;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.statements.StatementWithoutTrailingSubstatement;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ContinueStatement extends AstNode implements StatementWithoutTrailingSubstatement {

  private final String identifier;

  public ContinueStatement(Range range, AstNode parent,
                           String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public ContinueStatement(Position start, Position end, AstNode parent,
                           String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public ContinueStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                           String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }
}
