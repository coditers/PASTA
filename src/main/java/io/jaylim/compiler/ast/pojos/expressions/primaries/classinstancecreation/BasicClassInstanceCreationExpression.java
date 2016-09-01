package io.jaylim.compiler.ast.pojos.expressions.primaries.classinstancecreation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.classes.ClassBodyDeclaration;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.types.TypeArgument;
import io.jaylim.compiler.ast.pojos.types.TypeArgumentsOrDiamond;

/**
 * TODO - Compose test case
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BasicClassInstanceCreationExpression extends ClassInstanceCreationExpression
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
               LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final List<TypeArgument> typeArgumentList;
  private final List<List<Annotation>> annotationListList;
  private final List<String> identifierList;
  private final TypeArgumentsOrDiamond typeArgumentsOrDiamond;
  private final List<Expression> argumentList;
  private final List<ClassBodyDeclaration> classBody;

  public BasicClassInstanceCreationExpression(Range range, AstNode parent,
                                              List<TypeArgument> typeArgumentList,
                                              List<List<Annotation>> annotationListList,
                                              List<String> identifierList,
                                              TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                              List<Expression> argumentList,
                                              List<ClassBodyDeclaration> classBody) {
    super(range, parent);
    this.typeArgumentList = typeArgumentList;
    this.annotationListList = annotationListList;
    this.identifierList = identifierList;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  public BasicClassInstanceCreationExpression(Position start, Position end, AstNode parent,
                                              List<TypeArgument> typeArgumentList,
                                              List<List<Annotation>> annotationListList,
                                              List<String> identifierList,
                                              TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                              List<Expression> argumentList,
                                              List<ClassBodyDeclaration> classBody) {
    super(start, end, parent);
    this.typeArgumentList = typeArgumentList;
    this.annotationListList = annotationListList;
    this.identifierList = identifierList;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  public BasicClassInstanceCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                              List<TypeArgument> typeArgumentList,
                                              List<List<Annotation>> annotationListList,
                                              List<String> identifierList,
                                              TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                              List<Expression> argumentList,
                                              List<ClassBodyDeclaration> classBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeArgumentList = typeArgumentList;
    this.annotationListList = annotationListList;
    this.identifierList = identifierList;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  @JsonProperty(value="TypeArgumentList")
  public List<TypeArgument> getTypeArgumentList() {
    return Collections.unmodifiableList(typeArgumentList);
  }

  @JsonProperty(value="AnnotationListList")
  public List<List<Annotation>> getAnnotationListList() {
    return Collections.unmodifiableList(annotationListList);
  }

  @JsonProperty(value="IdentifierList")
  public List<String> getIdentifierList() {
    return Collections.unmodifiableList(identifierList);
  }

  @JsonProperty(value="TypeArgumentsOrDiamond")
  public TypeArgumentsOrDiamond getTypeArgumentsOrDiamond() {
    return typeArgumentsOrDiamond;
  }

  @JsonProperty(value="ArgumentList")
  public List<Expression> getArgumentList() {
    return argumentList;
  }

  @JsonProperty(value="ClassBody")
  public List<ClassBodyDeclaration> getClassBody() {
    return classBody;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof BasicClassInstanceCreationExpression)) return false;

    BasicClassInstanceCreationExpression that = (BasicClassInstanceCreationExpression) o;

    if (typeArgumentList != null ? !typeArgumentList.equals(that.typeArgumentList) : that.typeArgumentList != null)
      return false;
    if (annotationListList != null ? !annotationListList.equals(that.annotationListList) : that.annotationListList != null)
      return false;
    if (identifierList != null ? !identifierList.equals(that.identifierList) : that.identifierList != null)
      return false;
    if (typeArgumentsOrDiamond != null ? !typeArgumentsOrDiamond.equals(that.typeArgumentsOrDiamond) : that.typeArgumentsOrDiamond != null)
      return false;
    if (argumentList != null ? !argumentList.equals(that.argumentList) : that.argumentList != null)
      return false;
    return classBody != null ? classBody.equals(that.classBody) : that.classBody == null;

  }

  @Override
  public int hashCode() {
    int result = typeArgumentList != null ? typeArgumentList.hashCode() : 0;
    result = 31 * result + (annotationListList != null ? annotationListList.hashCode() : 0);
    result = 31 * result + (identifierList != null ? identifierList.hashCode() : 0);
    result = 31 * result + (typeArgumentsOrDiamond != null ? typeArgumentsOrDiamond.hashCode() : 0);
    result = 31 * result + (argumentList != null ? argumentList.hashCode() : 0);
    result = 31 * result + (classBody != null ? classBody.hashCode() : 0);
    return result;
  }
}
