package codit.ast.pojos.expressions.primaries.classinstancecreation;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.PrimaryExpression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ClassInstanceCreationExpression extends PrimaryExpression {
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
