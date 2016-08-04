package codit.ast.pojos.expressions.lambdas;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.Expression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LambdaExpression extends Expression {

  private final LambdaParameters lambdaParameters;
  private final LambdaBody lambdaBody;

  public LambdaExpression(Range range, AstNode parent,
                          LambdaParameters lambdaParameters,
                          LambdaBody lambdaBody) {
    super(range, parent);
    this.lambdaParameters = lambdaParameters;
    this.lambdaBody = lambdaBody;
  }

  public LambdaExpression(Position start, Position end, AstNode parent,
                          LambdaParameters lambdaParameters,
                          LambdaBody lambdaBody) {
    super(start, end, parent);
    this.lambdaParameters = lambdaParameters;
    this.lambdaBody = lambdaBody;
  }

  public LambdaExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                          LambdaParameters lambdaParameters,
                          LambdaBody lambdaBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.lambdaParameters = lambdaParameters;
    this.lambdaBody = lambdaBody;
  }
}
