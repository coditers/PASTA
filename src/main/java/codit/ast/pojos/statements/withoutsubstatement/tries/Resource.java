package codit.ast.pojos.statements.withoutsubstatement.tries;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.types.unann.UnannType;
import codit.ast.pojos.variables.VariableDeclarator;
import codit.ast.pojos.variables.VariableDeclaratorId;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Resource extends AstNode {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final UnannType unannType;

  private final VariableDeclaratorId variableDeclaratorId;

  private final Expression expression;

  public Resource(Range range, AstNode parent,
                  List<Annotation> annotationList,
                  int modifiers,
                  UnannType unannType,
                  VariableDeclaratorId variableDeclaratorId,
                  Expression expression) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorId = variableDeclaratorId;
    this.expression = expression;
  }

  public Resource(Position start, Position end, AstNode parent,
                  List<Annotation> annotationList,
                  int modifiers,
                  UnannType unannType,
                  VariableDeclaratorId variableDeclaratorId,
                  Expression expression) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorId = variableDeclaratorId;
    this.expression = expression;
  }

  public Resource(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                  List<Annotation> annotationList,
                  int modifiers,
                  UnannType unannType,
                  VariableDeclaratorId variableDeclaratorId,
                  Expression expression) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorId = variableDeclaratorId;
    this.expression = expression;
  }
}
