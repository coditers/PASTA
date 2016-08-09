package codit.ast.pojos.expressions;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.statements.normal.ForInit;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class StatementExpressionList extends AstNode implements ForInit {

  private final List<StatementExpression> statementExpressionList;

  public StatementExpressionList(Range range, AstNode parent,
                                 List<StatementExpression> statementExpressionList) {
    super(range, parent);
    this.statementExpressionList = statementExpressionList;
  }

  public StatementExpressionList(Position start, Position end, AstNode parent,
                                 List<StatementExpression> statementExpressionList) {
    super(start, end, parent);
    this.statementExpressionList = statementExpressionList;
  }

  public StatementExpressionList(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                 List<StatementExpression> statementExpressionList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.statementExpressionList = statementExpressionList;
  }
}
