package io.jaylim.compiler.ast.pojos.classes.members;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.variables.VariableDeclarator;
import io.jaylim.compiler.ast.pojos.types.unann.UnannType;

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
