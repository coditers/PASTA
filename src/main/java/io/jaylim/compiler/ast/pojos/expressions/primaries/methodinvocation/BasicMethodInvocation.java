package io.jaylim.compiler.ast.pojos.expressions.primaries.methodinvocation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.names.MethodName;

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

  @JsonProperty("MethodName")
  public MethodName getMethodName() {
    return methodName;
  }

  @JsonProperty("ArgumentList")
  public List<Expression> getArgumentList() {
    return argumentList;
  }
}
