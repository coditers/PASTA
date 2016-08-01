package codit.ast.pojos.statements.noshortif;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.statements.StatementNoShortIf;
import codit.ast.pojos.types.unann.UnannType;
import codit.ast.pojos.variables.VariableDeclaratorId;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class EnhancedForStatementNoShortIf extends ForStatementNoShortIf {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final UnannType unannType;

  private final VariableDeclaratorId variableDeclaratorId;

  private final Expression expression;

  private final StatementNoShortIf statementNoShortIf;

  public EnhancedForStatementNoShortIf(Range range, AstNode parent,
                                       List<Annotation> annotationList,
                                       int modifiers,
                                       UnannType unannType,
                                       VariableDeclaratorId variableDeclaratorId,
                                       Expression expression,
                                       StatementNoShortIf statementNoShortIf) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorId = variableDeclaratorId;
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
  }

  public EnhancedForStatementNoShortIf(Position start, Position end, AstNode parent,
                                       List<Annotation> annotationList,
                                       int modifiers,
                                       UnannType unannType,
                                       VariableDeclaratorId variableDeclaratorId,
                                       Expression expression,
                                       StatementNoShortIf statementNoShortIf) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorId = variableDeclaratorId;
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
  }

  public EnhancedForStatementNoShortIf(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                       List<Annotation> annotationList,
                                       int modifiers,
                                       UnannType unannType,
                                       VariableDeclaratorId variableDeclaratorId,
                                       Expression expression,
                                       StatementNoShortIf statementNoShortIf) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorId = variableDeclaratorId;
    this.expression = expression;
    this.statementNoShortIf = statementNoShortIf;
  }
}
