package codit.ast.pojos.classes.members;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.classes.Result;
import codit.ast.pojos.types.TypeParameter;
import codit.ast.pojos.types.exceptions.ExceptionType;

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
}
