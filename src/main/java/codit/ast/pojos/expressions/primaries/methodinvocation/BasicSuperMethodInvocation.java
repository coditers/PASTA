package codit.ast.pojos.expressions.primaries.methodinvocation;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.Expression;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BasicSuperMethodInvocation extends MethodInvocation
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final TypeArguments typeArguments;
  private final String identifier;
  private final List<Expression> argumentList;

  public BasicSuperMethodInvocation(Range range, AstNode parent,
                                    TypeArguments typeArguments,
                                    String identifier,
                                    List<Expression> argumentList) {
    super(range, parent);
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
  }

  public BasicSuperMethodInvocation(Position start, Position end, AstNode parent,
                                    TypeArguments typeArguments,
                                    String identifier,
                                    List<Expression> argumentList) {
    super(start, end, parent);
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
  }

  public BasicSuperMethodInvocation(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                    TypeArguments typeArguments,
                                    String identifier,
                                    List<Expression> argumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeArguments = typeArguments;
    this.identifier = identifier;
    this.argumentList = argumentList;
  }
}
