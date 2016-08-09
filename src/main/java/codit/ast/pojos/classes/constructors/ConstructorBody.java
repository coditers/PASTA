package codit.ast.pojos.classes.constructors;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.blocks.BlockStatements;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ConstructorBody extends AstNode {

  private final ExplicitConstructorInvocation explicitConstructorInvcation;

  private final BlockStatements blockStatements;

  public ConstructorBody(Range range, AstNode parent,
                         ExplicitConstructorInvocation explicitConstructorInvcation,
                         BlockStatements blockStatements) {
    super(range, parent);
    this.explicitConstructorInvcation = explicitConstructorInvcation;
    this.blockStatements = blockStatements;
  }

  public ConstructorBody(Position start, Position end, AstNode parent,
                         ExplicitConstructorInvocation explicitConstructorInvcation,
                         BlockStatements blockStatements) {
    super(start, end, parent);
    this.explicitConstructorInvcation = explicitConstructorInvcation;
    this.blockStatements = blockStatements;
  }

  public ConstructorBody(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                         ExplicitConstructorInvocation explicitConstructorInvcation,
                         BlockStatements blockStatements) {
    super(startLine, startCol, endLine, endCol, parent);
    this.explicitConstructorInvcation = explicitConstructorInvcation;
    this.blockStatements = blockStatements;
  }
}
