package codit.ast.pojos.expressions.primaries.classinstancecreation;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.StatementExpression;
import codit.ast.pojos.expressions.primaries.PrimaryExpression;

/**
 * TODO - Compose test case
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ClassInstanceCreationExpression extends PrimaryExpression implements StatementExpression {
  public ClassInstanceCreationExpression(Range range, AstNode parent) {
    super(range, parent);
  }

  public ClassInstanceCreationExpression(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ClassInstanceCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
