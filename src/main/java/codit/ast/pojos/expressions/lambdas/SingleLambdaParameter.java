package codit.ast.pojos.expressions.lambdas;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SingleLambdaParameter extends LambdaParameters {

  private final String identifier;

  public SingleLambdaParameter(Range range, AstNode parent,
                               String identifier) {
    super(range, parent);
    this.identifier = identifier;
  }

  public SingleLambdaParameter(Position start, Position end, AstNode parent,
                               String identifier) {
    super(start, end, parent);
    this.identifier = identifier;
  }

  public SingleLambdaParameter(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                               String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
  }
}
