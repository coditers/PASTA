package codit.ast.pojos.expressions.primaries.methodreference;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.Primary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimaryMethodReference extends MethodReference
    implements DefaultArrayDefaultPrimary, LfnoArrayDefaultPrimary {

  private final Primary primary;

  private final TypeArguments typeArguments;
  private final String identifier;

  public PrimaryMethodReference(Range range, AstNode parent,
                                Primary primary,
                                TypeArguments typeArguments,
                                String identifier) {
    super(range, parent);
    this.primary = primary;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public PrimaryMethodReference(Position start, Position end, AstNode parent,
                                Primary primary,
                                TypeArguments typeArguments,
                                String identifier) {
    super(start, end, parent);
    this.primary = primary;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public PrimaryMethodReference(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                Primary primary,
                                TypeArguments typeArguments,
                                String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.primary = primary;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }
}
