package io.jaylim.compiler.ast.pojos.expressions.primaries.classinstancecreation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.classes.ClassBodyDeclaration;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.expressions.primaries.Primary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.types.TypeArgument;
import io.jaylim.compiler.ast.pojos.types.TypeArgumentsOrDiamond;

/**
 * TODO - Compose test case
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimaryClassInstanceCreationExpression extends ClassInstanceCreationExpression
    implements LfnoArrayDefaultPrimary, DefaultArrayDefaultPrimary {

  private final Primary primary;
  private final List<TypeArgument> typeArgumentList;
  private final List<Annotation> annotationList;
  private final String identifier;
  private final TypeArgumentsOrDiamond typeArgumentsOrDiamond;
  private final List<Expression> argumentList;
  private final List<ClassBodyDeclaration> classBody;

  public PrimaryClassInstanceCreationExpression(Range range, AstNode parent,
                                                Primary primary,
                                                List<TypeArgument> typeArgumentList,
                                                List<Annotation> annotationList,
                                                String identifier,
                                                TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                                List<Expression> argumentList,
                                                List<ClassBodyDeclaration> classBody) {
    super(range, parent);
    this.primary = primary;
    this.typeArgumentList = typeArgumentList;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  public PrimaryClassInstanceCreationExpression(Position start, Position end, AstNode parent,
                                                Primary primary,
                                                List<TypeArgument> typeArgumentList,
                                                List<Annotation> annotationList,
                                                String identifier,
                                                TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                                List<Expression> argumentList,
                                                List<ClassBodyDeclaration> classBody) {
    super(start, end, parent);
    this.primary = primary;
    this.typeArgumentList = typeArgumentList;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  public PrimaryClassInstanceCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                                Primary primary,
                                                List<TypeArgument> typeArgumentList,
                                                List<Annotation> annotationList,
                                                String identifier,
                                                TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                                List<Expression> argumentList,
                                                List<ClassBodyDeclaration> classBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.primary = primary;
    this.typeArgumentList = typeArgumentList;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  @JsonProperty("Primary")
  public Primary getPrimary() {
    return primary;
  }

  @JsonProperty("TypeArgumentList")
  public List<TypeArgument> getTypeArgumentList() {
    return typeArgumentList;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty("TypeArgumentsOrDiamond")
  public TypeArgumentsOrDiamond getTypeArgumentsOrDiamond() {
    return typeArgumentsOrDiamond;
  }

  @JsonProperty("ArgumentList")
  public List<Expression> getArgumentList() {
    return argumentList;
  }

  @JsonProperty("ClassBody")
  public List<ClassBodyDeclaration> getClassBody() {
    return classBody;
  }


}
