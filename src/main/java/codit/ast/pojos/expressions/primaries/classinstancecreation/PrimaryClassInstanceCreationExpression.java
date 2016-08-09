package codit.ast.pojos.expressions.primaries.classinstancecreation;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.annotations.Annotation;
import codit.ast.pojos.classes.ClassBodyDeclaration;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.primaries.Primary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.types.TypeArgument;
import codit.ast.pojos.types.TypeArgumentsOrDiamond;

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
}
