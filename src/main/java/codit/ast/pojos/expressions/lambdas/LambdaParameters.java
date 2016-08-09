package codit.ast.pojos.expressions.lambdas;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class LambdaParameters extends AstNode {

  public LambdaParameters(Range range, AstNode parent) {
    super(range, parent);
  }

  public LambdaParameters(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public LambdaParameters(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
