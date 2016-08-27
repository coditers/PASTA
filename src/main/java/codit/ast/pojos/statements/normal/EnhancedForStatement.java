package codit.ast.pojos.statements.normal;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.statements.Statement;
import codit.ast.pojos.types.unann.UnannType;
import codit.ast.pojos.variables.VariableDeclaratorId;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class EnhancedForStatement extends ForStatement {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final UnannType unannType;

  private final VariableDeclaratorId variableDeclaratorId;

  private final Expression expression;

  private final Statement statement;

  public EnhancedForStatement(Range range, AstNode parent,
                              List<Annotation> annotationList,
                              int modifiers,
                              UnannType unannType,
                              VariableDeclaratorId variableDeclaratorId,
                              Expression expression,
                              Statement statement) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorId = variableDeclaratorId;
    this.expression = expression;
    this.statement = statement;
  }

  public EnhancedForStatement(Position start, Position end, AstNode parent,
                              List<Annotation> annotationList,
                              int modifiers,
                              UnannType unannType,
                              VariableDeclaratorId variableDeclaratorId,
                              Expression expression,
                              Statement statement) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorId = variableDeclaratorId;
    this.expression = expression;
    this.statement = statement;
  }

  public EnhancedForStatement(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                              List<Annotation> annotationList,
                              int modifiers,
                              UnannType unannType,
                              VariableDeclaratorId variableDeclaratorId,
                              Expression expression,
                              Statement statement) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorId = variableDeclaratorId;
    this.expression = expression;
    this.statement = statement;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Modifiers")
  public int getModifiers() {
    return modifiers;
  }

  @JsonProperty("UnannType")
  public UnannType getUnannType() {
    return unannType;
  }

  @JsonProperty("VariableDeclaratorId")
  public VariableDeclaratorId getVariableDeclaratorId() {
    return variableDeclaratorId;
  }

  @JsonProperty("Expression")
  public Expression getExpression() {
    return expression;
  }

  @JsonProperty("Statement")
  public Statement getStatement() {
    return statement;
  }
}
