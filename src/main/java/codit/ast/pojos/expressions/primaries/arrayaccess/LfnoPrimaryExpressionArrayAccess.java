package codit.ast.pojos.expressions.primaries.arrayaccess;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfArrayLfnoPrimary;
import codit.ast.pojos.names.ExpressionName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LfnoPrimaryExpressionArrayAccess extends ArrayAccess
    implements DefaultArrayLfnoPrimary {

  private final ExpressionName expressionName;
  private final Expression firstExpression;

  private final List<LfArrayLfnoPrimary> lfArrayLfnoPrimaryList;
  private final List<Expression> expressionList;

  public LfnoPrimaryExpressionArrayAccess(Range range, AstNode parent,
                                          ExpressionName expressionName,
                                          Expression firstExpression,
                                          List<LfArrayLfnoPrimary> lfArrayLfnoPrimaryList,
                                          List<Expression> expressionList) {
    super(range, parent);
    this.expressionName = expressionName;
    this.firstExpression = firstExpression;
    this.lfArrayLfnoPrimaryList = lfArrayLfnoPrimaryList;
    this.expressionList = expressionList;
  }

  public LfnoPrimaryExpressionArrayAccess(Position start, Position end, AstNode parent,
                                          ExpressionName expressionName,
                                          Expression firstExpression,
                                          List<LfArrayLfnoPrimary> lfArrayLfnoPrimaryList,
                                          List<Expression> expressionList) {
    super(start, end, parent);
    this.expressionName = expressionName;
    this.firstExpression = firstExpression;
    this.lfArrayLfnoPrimaryList = lfArrayLfnoPrimaryList;
    this.expressionList = expressionList;
  }

  public LfnoPrimaryExpressionArrayAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                          ExpressionName expressionName,
                                          Expression firstExpression,
                                          List<LfArrayLfnoPrimary> lfArrayLfnoPrimaryList,
                                          List<Expression> expressionList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expressionName = expressionName;
    this.firstExpression = firstExpression;
    this.lfArrayLfnoPrimaryList = lfArrayLfnoPrimaryList;
    this.expressionList = expressionList;
  }
}
