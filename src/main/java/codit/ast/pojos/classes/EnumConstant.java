package codit.ast.pojos.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.expressions.Expression;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class EnumConstant extends AstNode {

  private final List<Annotation> annotationList;

  private final String identifier;

  private final List<Expression> argumentList;

  private final List<ClassBodyDeclaration> classBodyDeclarationList;

  public EnumConstant(Range range, AstNode parent,
                      List<Annotation> annotationList,
                      String identifier,
                      List<Expression> argumentList,
                      List<ClassBodyDeclaration> classBodyDeclarationList) {
    super(range, parent);
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.argumentList = argumentList;
    this.classBodyDeclarationList = classBodyDeclarationList;
  }

  public EnumConstant(Position start, Position end, AstNode parent,
                      List<Annotation> annotationList,
                      String identifier,
                      List<Expression> argumentList,
                      List<ClassBodyDeclaration> classBodyDeclarationList) {
    super(start, end, parent);
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.argumentList = argumentList;
    this.classBodyDeclarationList = classBodyDeclarationList;
  }

  public EnumConstant(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                      List<Annotation> annotationList,
                      String identifier,
                      List<Expression> argumentList,
                      List<ClassBodyDeclaration> classBodyDeclarationList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.argumentList = argumentList;
    this.classBodyDeclarationList = classBodyDeclarationList;
  }

  @JsonProperty("AnnotationList")
  public List<Annotation> getAnnotationList() {
    return annotationList;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }

  @JsonProperty("ArgumentList")
  public List<Expression> getArgumentList() {
    return argumentList;
  }

  @JsonProperty("ClassBodyDeclarationList")
  public List<ClassBodyDeclaration> getClassBodyDeclarationList() {
    return classBodyDeclarationList;
  }
}
