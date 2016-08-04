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
import codit.ast.pojos.names.ExpressionName;
import codit.ast.pojos.types.TypeArgument;
import codit.ast.pojos.types.TypeArgumentsOrDiamond;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ExpressionClassInstanceCreationExpression extends ClassInstanceCreationExpression
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
               LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {


  private final ExpressionName expressionName;
  private final List<TypeArgument> typeArgumentList;
  private final List<Annotation> annotationList;
  private final String identifier;
  private final TypeArgumentsOrDiamond typeArgumentsOrDiamond;
  private final List<Expression> argumentList;
  private final List<ClassBodyDeclaration> classBody;

  public ExpressionClassInstanceCreationExpression(Range range, AstNode parent,
                                                   ExpressionName expressionName,
                                                   List<TypeArgument> typeArgumentList,
                                                   List<Annotation> annotationList,
                                                   String identifier,
                                                   TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                                   List<Expression> argumentList,
                                                   List<ClassBodyDeclaration> classBody) {
    super(range, parent);
    this.expressionName = expressionName;
    this.typeArgumentList = typeArgumentList;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  public ExpressionClassInstanceCreationExpression(Position start, Position end, AstNode parent,
                                                   ExpressionName expressionName,
                                                   List<TypeArgument> typeArgumentList,
                                                   List<Annotation> annotationList,
                                                   String identifier,
                                                   TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                                   List<Expression> argumentList,
                                                   List<ClassBodyDeclaration> classBody) {
    super(start, end, parent);
    this.expressionName = expressionName;
    this.typeArgumentList = typeArgumentList;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }

  public ExpressionClassInstanceCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                                   ExpressionName expressionName,
                                                   List<TypeArgument> typeArgumentList,
                                                   List<Annotation> annotationList,
                                                   String identifier,
                                                   TypeArgumentsOrDiamond typeArgumentsOrDiamond,
                                                   List<Expression> argumentList,
                                                   List<ClassBodyDeclaration> classBody) {
    super(startLine, startCol, endLine, endCol, parent);
    this.expressionName = expressionName;
    this.typeArgumentList = typeArgumentList;
    this.annotationList = annotationList;
    this.identifier = identifier;
    this.typeArgumentsOrDiamond = typeArgumentsOrDiamond;
    this.argumentList = argumentList;
    this.classBody = classBody;
  }
}
