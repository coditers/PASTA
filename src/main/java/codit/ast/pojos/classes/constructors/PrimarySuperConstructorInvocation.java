package codit.ast.pojos.classes.constructors;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.primaries.Primary;
import codit.ast.pojos.types.TypeArgument;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimarySuperConstructorInvocation extends ExplicitConstructorInvocation {

  private final Primary primary;

  public PrimarySuperConstructorInvocation(Range range, AstNode parent,
                                           List<TypeArgument> typeArgumentList,
                                           List<Expression> argumentList,
                                           Primary primary) {
    super(range, parent, typeArgumentList, argumentList);
    this.primary = primary;
  }

  public PrimarySuperConstructorInvocation(Position start, Position end, AstNode parent,
                                           List<TypeArgument> typeArgumentList,
                                           List<Expression> argumentList,
                                           Primary primary) {
    super(start, end, parent, typeArgumentList, argumentList);
    this.primary = primary;
  }

  public PrimarySuperConstructorInvocation(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                           List<TypeArgument> typeArgumentList,
                                           List<Expression> argumentList,
                                           Primary primary) {
    super(startLine, startCol, endLine, endCol, parent, typeArgumentList, argumentList);
    this.primary = primary;
  }
}
