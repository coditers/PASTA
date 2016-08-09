package codit.ast.pojos.classes.constructors;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.classes.ClassBodyDeclaration;
import codit.ast.pojos.types.exceptions.ExceptionType;

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
}
