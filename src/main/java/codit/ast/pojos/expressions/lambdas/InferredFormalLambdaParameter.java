package codit.ast.pojos.expressions.lambdas;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class InferredFormalLambdaParameter extends LambdaParameters {

  private final List<String> identifierList;

  public InferredFormalLambdaParameter(Range range, AstNode parent,
                                       List<String> identifierList) {
    super(range, parent);
    this.identifierList = identifierList;
  }

  public InferredFormalLambdaParameter(Position start, Position end, AstNode parent,
                                       List<String> identifierList) {
    super(start, end, parent);
    this.identifierList = identifierList;
  }

  public InferredFormalLambdaParameter(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                       List<String> identifierList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifierList = identifierList;
  }
}
