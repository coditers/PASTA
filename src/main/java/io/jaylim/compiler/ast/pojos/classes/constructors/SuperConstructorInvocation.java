package io.jaylim.compiler.ast.pojos.classes.constructors;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.types.TypeArgument;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SuperConstructorInvocation extends ExplicitConstructorInvocation {

  public SuperConstructorInvocation(Range range, AstNode parent, List<TypeArgument> typeArgumentList, List<Expression> argumentList) {
    super(range, parent, typeArgumentList, argumentList);
  }

  public SuperConstructorInvocation(Position start, Position end, AstNode parent, List<TypeArgument> typeArgumentList, List<Expression> argumentList) {
    super(start, end, parent, typeArgumentList, argumentList);
  }

  public SuperConstructorInvocation(int startLine, int startCol, int endLine, int endCol, AstNode parent, List<TypeArgument> typeArgumentList, List<Expression> argumentList) {
    super(startLine, startCol, endLine, endCol, parent, typeArgumentList, argumentList);
  }
}
