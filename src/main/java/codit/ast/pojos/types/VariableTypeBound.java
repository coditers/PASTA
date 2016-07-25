package codit.ast.pojos.types;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class VariableTypeBound extends TypeBound {

  private final TypeVariable typeVariable;

  public VariableTypeBound(Range range, AstNode parent,
                           TypeVariable typeVariable) {
    super(range, parent);
    this.typeVariable = typeVariable;
  }

  public VariableTypeBound(Position start, Position end, AstNode parent,
                           TypeVariable typeVariable) {
    super(start, end, parent);
    this.typeVariable = typeVariable;
  }

  public VariableTypeBound(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                           TypeVariable typeVariable) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeVariable = typeVariable;
  }
}
