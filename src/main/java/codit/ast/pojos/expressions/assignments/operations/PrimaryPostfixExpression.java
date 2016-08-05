package codit.ast.pojos.expressions.assignments.operations;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.Primary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimaryPostfixExpression extends PostfixExpression {

  private final Primary primary;
  private final List<Boolean> isPlusList;

  public PrimaryPostfixExpression(Range range, AstNode parent, Primary primary, List<Boolean> isPlusList) {
    super(range, parent);
    this.primary = primary;
    this.isPlusList = isPlusList;
  }

  public PrimaryPostfixExpression(Position start, Position end, AstNode parent, Primary primary, List<Boolean> isPlusList) {
    super(start, end, parent);
    this.primary = primary;
    this.isPlusList = isPlusList;
  }

  public PrimaryPostfixExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent, Primary primary, List<Boolean> isPlusList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.primary = primary;
    this.isPlusList = isPlusList;
  }
}
