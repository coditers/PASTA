package codit.ast.pojos.blocks;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.statements.normal.ForInit;
import codit.ast.pojos.types.unann.UnannType;
import codit.ast.pojos.variables.VariableDeclarator;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LocalVariableDeclaration extends AstNode implements ForInit {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final UnannType unannType;

  private final List<VariableDeclarator> variableDeclaratorList;

  public LocalVariableDeclaration(Range range, AstNode parent,
                                  List<Annotation> annotationList,
                                  int modifiers,
                                  UnannType unannType,
                                  List<VariableDeclarator> variableDeclaratorList) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorList = variableDeclaratorList;
  }

  public LocalVariableDeclaration(Position start, Position end, AstNode parent,
                                  List<Annotation> annotationList,
                                  int modifiers,
                                  UnannType unannType,
                                  List<VariableDeclarator> variableDeclaratorList) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorList = variableDeclaratorList;
  }

  public LocalVariableDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                  List<Annotation> annotationList,
                                  int modifiers,
                                  UnannType unannType,
                                  List<VariableDeclarator> variableDeclaratorList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorList = variableDeclaratorList;
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

  @JsonProperty("VariableDeclaratorList")
  public List<VariableDeclarator> getVariableDeclaratorList() {
    return variableDeclaratorList;
  }
}
