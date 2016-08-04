package codit.ast.pojos.expressions.primaries.classinstancecreation;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.classes.ClassBodyDeclaration;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfPrimary;
import codit.ast.pojos.types.TypeArgument;
import codit.ast.pojos.types.TypeArgumentsOrDiamond;

/**
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
}
