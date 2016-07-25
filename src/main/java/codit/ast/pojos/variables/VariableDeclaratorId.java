package codit.ast.pojos.variables;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.types.Dims;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class VariableDeclaratorId extends AstNode {

  private final String identifier;
  private final Dims dims;

  public VariableDeclaratorId(Range range, AstNode parent,
                              String identifier,
                              Dims dims) {
    super(range, parent);
    this.identifier = identifier;
    this.dims = dims;
  }

  public VariableDeclaratorId(Position start, Position end, AstNode parent,
                              String identifier,
                              Dims dims) {
    super(start, end, parent);
    this.identifier = identifier;
    this.dims = dims;
  }

  public VariableDeclaratorId(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                              String identifier,
                              Dims dims) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
    this.dims = dims;
  }
}
