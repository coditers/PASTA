package codit.ast.pojos.classes.constructors;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.types.TypeArgument;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ExplicitConstructorInvocation extends AstNode {

  private final List<TypeArgument> typeArgumentList;

  private final List<Expression> argumentList;

  public ExplicitConstructorInvocation(Range range, AstNode parent,
                                       List<TypeArgument> typeArgumentList,
                                       List<Expression> argumentList) {
    super(range, parent);
    this.typeArgumentList = typeArgumentList;
    this.argumentList = argumentList;
  }

  public ExplicitConstructorInvocation(Position start, Position end, AstNode parent,
                                       List<TypeArgument> typeArgumentList,
                                       List<Expression> argumentList) {
    super(start, end, parent);
    this.typeArgumentList = typeArgumentList;
    this.argumentList = argumentList;
  }

  public ExplicitConstructorInvocation(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                       List<TypeArgument> typeArgumentList,
                                       List<Expression> argumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeArgumentList = typeArgumentList;
    this.argumentList = argumentList;
  }
}
