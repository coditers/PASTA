package codit.ast.pojos.expressions.primaries.fieldaccess;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.assignments.LeftHandSide;
import codit.ast.pojos.expressions.primaries.Primary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimaryFieldAccess extends FieldAccess
    implements DefaultArrayDefaultPrimary, LfnoArrayDefaultPrimary, LeftHandSide {

  private final Primary primary;
  private final String identifier;

  public PrimaryFieldAccess(Range range, AstNode parent, Primary primary, String identifier) {
    super(range, parent);
    this.primary = primary;
    this.identifier = identifier;
  }

  public PrimaryFieldAccess(Position start, Position end, AstNode parent, Primary primary, String identifier) {
    super(start, end, parent);
    this.primary = primary;
    this.identifier = identifier;
  }

  public PrimaryFieldAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent, Primary primary, String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.primary = primary;
    this.identifier = identifier;
  }

  @JsonProperty("Primary")
  public Primary getPrimary() {
    return primary;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }
}
