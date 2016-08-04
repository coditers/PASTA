package codit.ast.pojos.expressions.primaries.arrayaccess;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfArrayLfPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LfPrimaryArrayAccess extends ArrayAccess
    implements DefaultArrayLfPrimary {


  private final LfnoArrayLfPrimary lfnoArrayLfPrimary;
  private final Expression firstExpression;

  private final List<LfArrayLfPrimary> lfArrayLfPrimaryList;
  private final List<Expression> expressionList;


  public LfPrimaryArrayAccess(Range range, AstNode parent,
                              LfnoArrayLfPrimary lfnoArrayLfPrimary,
                              Expression firstExpression,
                              List<LfArrayLfPrimary> lfArrayLfPrimaryList,
                              List<Expression> expressionList) {
    super(range, parent);
    this.lfnoArrayLfPrimary = lfnoArrayLfPrimary;
    this.firstExpression = firstExpression;
    this.lfArrayLfPrimaryList = lfArrayLfPrimaryList;
    this.expressionList = expressionList;
  }

  public LfPrimaryArrayAccess(Position start, Position end, AstNode parent,
                              LfnoArrayLfPrimary lfnoArrayLfPrimary,
                              Expression firstExpression,
                              List<LfArrayLfPrimary> lfArrayLfPrimaryList,
                              List<Expression> expressionList) {
    super(start, end, parent);
    this.lfnoArrayLfPrimary = lfnoArrayLfPrimary;
    this.firstExpression = firstExpression;
    this.lfArrayLfPrimaryList = lfArrayLfPrimaryList;
    this.expressionList = expressionList;
  }

  public LfPrimaryArrayAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                              LfnoArrayLfPrimary lfnoArrayLfPrimary,
                              Expression firstExpression,
                              List<LfArrayLfPrimary> lfArrayLfPrimaryList,
                              List<Expression> expressionList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.lfnoArrayLfPrimary = lfnoArrayLfPrimary;
    this.firstExpression = firstExpression;
    this.lfArrayLfPrimaryList = lfArrayLfPrimaryList;
    this.expressionList = expressionList;
  }
}
