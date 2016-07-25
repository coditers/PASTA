package codit.ast.pojos.variables;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class VariableDeclarator extends AstNode {

  private final VariableDeclaratorId variableDeclaratorId;

  private final VariableInitializer variableInitializer;

  public VariableDeclarator(Range range, AstNode parent,
                            VariableDeclaratorId variableDeclaratorId,
                            VariableInitializer variableInitializer) {
    super(range, parent);
    this.variableDeclaratorId = variableDeclaratorId;
    this.variableInitializer = variableInitializer;
  }

  public VariableDeclarator(Position start, Position end, AstNode parent,
                            VariableDeclaratorId variableDeclaratorId,
                            VariableInitializer variableInitializer) {
    super(start, end, parent);
    this.variableDeclaratorId = variableDeclaratorId;
    this.variableInitializer = variableInitializer;
  }

  public VariableDeclarator(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                            VariableDeclaratorId variableDeclaratorId,
                            VariableInitializer variableInitializer) {
    super(startLine, startCol, endLine, endCol, parent);
    this.variableDeclaratorId = variableDeclaratorId;
    this.variableInitializer = variableInitializer;
  }
}
