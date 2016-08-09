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
import codit.ast.pojos.names.MethodName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class BasicMethodInvocation extends MethodInvocation
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final MethodName methodName;
  private final List<Expression> argumentList;

  public BasicMethodInvocation(Range range, AstNode parent,
                               MethodName methodName,
                               List<Expression> argumentList) {
    super(range, parent);
    this.methodName = methodName;
    this.argumentList = argumentList;
  }

  public BasicMethodInvocation(Position start, Position end, AstNode parent,
                               MethodName methodName,
                               List<Expression> argumentList) {
    super(start, end, parent);
    this.methodName = methodName;
    this.argumentList = argumentList;
  }

  public BasicMethodInvocation(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                               MethodName methodName,
                               List<Expression> argumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.methodName = methodName;
    this.argumentList = argumentList;
  }
}
