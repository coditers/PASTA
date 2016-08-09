package codit.ast.pojos.expressions.lambdas;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
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

  @JsonProperty("LambdaParameters")
  public LambdaParameters getLambdaParameters() {
    return lambdaParameters;
  }

  @JsonProperty("LambdaBody")
  public LambdaBody getLambdaBody() {
    return lambdaBody;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof LambdaExpression)) return false;
    if (!super.equals(o)) return false;

    LambdaExpression that = (LambdaExpression) o;

    if (lambdaParameters != null ? !lambdaParameters.equals(that.lambdaParameters) : that.lambdaParameters != null)
      return false;
    return lambdaBody != null ? lambdaBody.equals(that.lambdaBody) : that.lambdaBody == null;

  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (lambdaParameters != null ? lambdaParameters.hashCode() : 0);
    result = 31 * result + (lambdaBody != null ? lambdaBody.hashCode() : 0);
    return result;
  }
}
