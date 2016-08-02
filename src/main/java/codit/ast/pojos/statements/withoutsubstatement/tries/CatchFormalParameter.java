package codit.ast.pojos.statements.withoutsubstatement.tries;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.variables.VariableDeclaratorId;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class CatchFormalParameter extends AstNode {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final CatchType catchType;

  private final VariableDeclaratorId variableDeclaratorId;

  public CatchFormalParameter(Range range, AstNode parent,
                              List<Annotation> annotationList,
                              int modifiers,
                              CatchType catchType,
                              VariableDeclaratorId variableDeclaratorId) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.catchType = catchType;
    this.variableDeclaratorId = variableDeclaratorId;
  }

  public CatchFormalParameter(Position start, Position end, AstNode parent,
                              List<Annotation> annotationList,
                              int modifiers,
                              CatchType catchType,
                              VariableDeclaratorId variableDeclaratorId) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.catchType = catchType;
    this.variableDeclaratorId = variableDeclaratorId;
  }

  public CatchFormalParameter(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                              List<Annotation> annotationList,
                              int modifiers,
                              CatchType catchType,
                              VariableDeclaratorId variableDeclaratorId) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.catchType = catchType;
    this.variableDeclaratorId = variableDeclaratorId;
  }
}
