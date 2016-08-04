package codit.ast.pojos.expressions.primaries.classinstancecreation;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.classes.ClassBodyDeclaration;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.types.TypeArgument;
import codit.ast.pojos.types.TypeArgumentsOrDiamond;

/**
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
}
