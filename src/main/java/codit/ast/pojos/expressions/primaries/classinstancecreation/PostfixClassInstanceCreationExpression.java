package codit.ast.pojos.expressions.primaries.classinstancecreation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Collections;
import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.classes.ClassBodyDeclaration;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfPrimary;
import codit.ast.pojos.types.TypeArgument;
import codit.ast.pojos.types.TypeArgumentsOrDiamond;

/**
 * TODO - Compose test case
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PostfixClassInstanceCreationExpression extends ClassInstanceCreationExpression
    implements DefaultArrayLfPrimary, LfnoArrayLfPrimary {

  private final List<TypeArgument> typeArgumentList;
  private final List<Annotation> annotationList;
  private final String identifier;
  private final TypeArgumentsOrDiamond typeArgumentsOrDiamond;
  private final List<Expression> argumentList;
  private final List<ClassBodyDeclaration> classBody;

  public PostfixClassInstanceCreationExpression(Range range, AstNode parent,
                                                List<TypeArgument> typeArgumentList,
                                                List<Annotation> annotationList,
                                                String identifier,
                                                TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                                List<Expression> argumentList,
                                                List<ClassBodyDeclaration> classBody) {
    super(range, parent);
    this.typeArgumentList = typeArgumentList;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  public PostfixClassInstanceCreationExpression(Position start, Position end, AstNode parent,
                                                List<TypeArgument> typeArgumentList,
                                                List<Annotation> annotationList,
                                                String identifier,
                                                TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                                List<Expression> argumentList,
                                                List<ClassBodyDeclaration> classBody) {
    super(start, end, parent);
    this.typeArgumentList = typeArgumentList;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  public PostfixClassInstanceCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                                List<TypeArgument> typeArgumentList,
                                                List<Annotation> annotationList,
                                                String identifier,
                                                TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                                List<Expression> argumentList,
                                                List<ClassBodyDeclaration> classBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeArgumentList = typeArgumentList;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  @JsonProperty(value="TypeArgumentList")
  public List<TypeArgument> getTypeArgumentList() {
    return Collections.unmodifiableList(typeArgumentList);
  }

  @JsonProperty(value="AnnotationList")
  public List<Annotation> getAnnotationList() {
    return Collections.unmodifiableList(annotationList);
  }

  @JsonProperty(value="Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty(value="TypeArgumentOrDiamond")
  public TypeArgumentsOrDiamond getTypeArgumentsOrDiamond() {
    return typeArgumentsOrDiamond;
  }

  @JsonProperty(value="ArgumentList")
  public List<Expression> getArgumentList() {
    return Collections.unmodifiableList(argumentList);
  }

  @JsonProperty(value="ClassBody")
  public List<ClassBodyDeclaration> getClassBody() {
    return classBody;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PostfixClassInstanceCreationExpression)) return false;

    PostfixClassInstanceCreationExpression that = (PostfixClassInstanceCreationExpression) o;

    if (typeArgumentList != null ? !typeArgumentList.equals(that.typeArgumentList) : that.typeArgumentList != null)
      return false;
    if (annotationList != null ? !annotationList.equals(that.annotationList) : that.annotationList != null)
      return false;
    if (identifier != null ? !identifier.equals(that.identifier) : that.identifier != null)
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
    result = 31 * result + (annotationList != null ? annotationList.hashCode() : 0);
    result = 31 * result + (identifier != null ? identifier.hashCode() : 0);
    result = 31 * result + (typeArgumentsOrDiamond != null ? typeArgumentsOrDiamond.hashCode() : 0);
    result = 31 * result + (argumentList != null ? argumentList.hashCode() : 0);
    result = 31 * result + (classBody != null ? classBody.hashCode() : 0);
    return result;
  }
}
