package codit.ast.pojos.classes.members;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.variables.VariableDeclarator;
import codit.ast.pojos.types.unann.UnannType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class FieldDeclaration extends AstNode implements ClassMemberable {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final UnannType unannType;

  private final List<VariableDeclarator> variableDeclaratorList;

  public FieldDeclaration(Range range, AstNode parent,
                          Collection<Annotation> annotationList,
                          int modifiers,
                          UnannType unannType,
                          Collection<VariableDeclarator> variableDeclaratorList) {
    super(range, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorList = new ArrayList<>(variableDeclaratorList);
  }

  public FieldDeclaration(Position start, Position end, AstNode parent,
                          Collection<Annotation> annotationList,
                          int modifiers,
                          UnannType unannType,
                          Collection<VariableDeclarator> variableDeclaratorList) {
    super(start, end, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorList = new ArrayList<>(variableDeclaratorList);
  }

  public FieldDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                          Collection<Annotation> annotationList,
                          int modifiers,
                          UnannType unannType,
                          Collection<VariableDeclarator> variableDeclaratorList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = new ArrayList<>(annotationList);
    this.modifiers = modifiers;
    this.unannType = unannType;
    this.variableDeclaratorList = new ArrayList<>(variableDeclaratorList);
  }
}
