package codit.ast.pojos.statements.noshortif;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.statements.StatementNoShortIf;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class IfThenElseStatementNoShortIf extends AstNode implements StatementNoShortIf {

  private final Expression expression;
  private final StatementNoShortIf statementNoShortIf;
  private final StatementNoShortIf elseStatementNoShortIf;

  public IfThenElseStatementNoShortIf(Range range, AstNode parent,
                                      Expression expression,
                                      StatementNoShortIf statementNoShortIf,
                                      StatementNoShortIf elseStatementNoShortIf) {
    super(range, parent);
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
    this.elseStatementNoShortIf = elseStatementNoShortIf;
  }

  public IfThenElseStatementNoShortIf(Position start, Position end, AstNode parent,
                                      Expression expression,
                                      StatementNoShortIf statementNoShortIf,
                                      StatementNoShortIf elseStatementNoShortIf) {
    super(start, end, parent);
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
    this.elseStatementNoShortIf = elseStatementNoShortIf;
  }

  public IfThenElseStatementNoShortIf(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                      Expression expression,
                                      StatementNoShortIf statementNoShortIf,
                                      StatementNoShortIf elseStatementNoShortIf) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
    this.elseStatementNoShortIf = elseStatementNoShortIf;
  }
}
