package codit.ast.pojos.expressions.primaries;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.arraycreationexpression.ArrayCreationExpression;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimaryArrayCreationExpression extends Primary {

  private final ArrayCreationExpression arrayCreationExpression;

  private final List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList;

  public PrimaryArrayCreationExpression(Range range, AstNode parent,
                                        ArrayCreationExpression arrayCreationExpression,
                                        List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList) {
    super(range, parent);
    this.arrayCreationExpression = arrayCreationExpression;
    this.defaultArrayLfPrimaryList = defaultArrayLfPrimaryList;
  }

  public PrimaryArrayCreationExpression(Position start, Position end, AstNode parent,
                                        ArrayCreationExpression arrayCreationExpression,
                                        List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList) {
    super(start, end, parent);
    this.arrayCreationExpression = arrayCreationExpression;
    this.defaultArrayLfPrimaryList = defaultArrayLfPrimaryList;
  }

  public PrimaryArrayCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                        ArrayCreationExpression arrayCreationExpression,
                                        List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.arrayCreationExpression = arrayCreationExpression;
    this.defaultArrayLfPrimaryList = defaultArrayLfPrimaryList;
  }
}
