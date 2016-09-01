package io.jaylim.compiler.ast.pojos.classes.members;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.annotations.Annotation;
import io.jaylim.compiler.ast.pojos.classes.Result;
import io.jaylim.compiler.ast.pojos.types.TypeParameter;
import io.jaylim.compiler.ast.pojos.types.exceptions.ExceptionType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class AnnotationMethodHeader extends MethodHeader {

  private final List<TypeParameter> TypeParameterList;
  private final List<Annotation> annotationList;

  public AnnotationMethodHeader(Range range, AstNode parent,
                                Result result,
                                MethodDeclarator methodDeclarator,
                                List<ExceptionType> exceptionTypeList,
                                List<TypeParameter> typeParameterList,
                                List<Annotation> annotationList) {
    super(range, parent, result, methodDeclarator, exceptionTypeList);
    TypeParameterList = typeParameterList;
    this.annotationList = annotationList;
  }

  public AnnotationMethodHeader(Position start, Position end, AstNode parent,
                                Result result,
                                MethodDeclarator methodDeclarator,
                                List<ExceptionType> exceptionTypeList,
                                List<TypeParameter> typeParameterList,
                                List<Annotation> annotationList) {
    super(start, end, parent, result, methodDeclarator, exceptionTypeList);
    TypeParameterList = typeParameterList;
    this.annotationList = annotationList;
  }

  public AnnotationMethodHeader(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                Result result,
                                MethodDeclarator methodDeclarator,
                                List<ExceptionType> exceptionTypeList,
                                List<TypeParameter> typeParameterList,
                                List<Annotation> annotationList) {
    super(startLine, startCol, endLine, endCol, parent, result, methodDeclarator, exceptionTypeList);
    TypeParameterList = typeParameterList;
    this.annotationList = annotationList;
  }

  @JsonProperty("TypeParameterList")
  public List<TypeParameter> getTypeParameterList() {
    return TypeParameterList;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }
}
