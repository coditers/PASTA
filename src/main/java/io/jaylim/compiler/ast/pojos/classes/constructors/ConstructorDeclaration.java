package io.jaylim.compiler.ast.pojos.classes.constructors;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.classes.ClassBodyDeclaration;
import io.jaylim.compiler.ast.pojos.types.exceptions.ExceptionType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ConstructorDeclaration extends ClassBodyDeclaration {

  private final List<Annotation> annotationList;
  private final int modifiers;

  private final ConstructorDeclarator constructorDeclarator;

  private final List<ExceptionType> exceptionTypeList;

  private final ConstructorBody constructorBody;

  public ConstructorDeclaration(Range range, AstNode parent,
                                List<Annotation> annotationList,
                                int modifiers,
                                ConstructorDeclarator constructorDeclarator,
                                List<ExceptionType> exceptionTypeList,
                                ConstructorBody constructorBody) {
    super(range, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.constructorDeclarator = constructorDeclarator;
    this.exceptionTypeList = exceptionTypeList;
    this.constructorBody = constructorBody;
  }

  public ConstructorDeclaration(Position start, Position end, AstNode parent,
                                List<Annotation> annotationList,
                                int modifiers,
                                ConstructorDeclarator constructorDeclarator,
                                List<ExceptionType> exceptionTypeList,
                                ConstructorBody constructorBody) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.constructorDeclarator = constructorDeclarator;
    this.exceptionTypeList = exceptionTypeList;
    this.constructorBody = constructorBody;
  }

  public ConstructorDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                List<Annotation> annotationList,
                                int modifiers,
                                ConstructorDeclarator constructorDeclarator,
                                List<ExceptionType> exceptionTypeList,
                                ConstructorBody constructorBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.modifiers = modifiers;
    this.constructorDeclarator = constructorDeclarator;
    this.exceptionTypeList = exceptionTypeList;
    this.constructorBody = constructorBody;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Modifiers")
  public int getModifiers() {
    return modifiers;
  }

  @JsonProperty("ConstructorDeclarator")
  public ConstructorDeclarator getConstructorDeclarator() {
    return constructorDeclarator;
  }

  @JsonProperty("ExceptionTypeList")
  public List<ExceptionType> getExceptionTypeList() {
    return exceptionTypeList;
  }

  @JsonProperty("ConstructorBody")
  public ConstructorBody getConstructorBody() {
    return constructorBody;
  }
}
