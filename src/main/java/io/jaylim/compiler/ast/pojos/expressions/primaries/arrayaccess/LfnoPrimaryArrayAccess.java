package io.jaylim.compiler.ast.pojos.expressions.primaries.arrayaccess;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.Expression;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class LfnoPrimaryArrayAccess extends ArrayAccess
    implements DefaultArrayLfnoPrimary {


  private final LfnoArrayLfnoPrimary lfnoArrayLfnoPrimary;
  private final Expression firstExpression;

  //private final List<LfArrayLfnoPrimary> lfArrayLfnoPrimaryList;
  private final List<Expression> expressionList;


  public LfnoPrimaryArrayAccess(Range range, AstNode parent,
                                LfnoArrayLfnoPrimary lfnoArrayLfnoPrimary,
                                Expression firstExpression,
                                //List<LfArrayLfnoPrimary> lfArrayLfnoPrimaryList,
                                List<Expression> expressionList) {
    super(range, parent);
    this.lfnoArrayLfnoPrimary = lfnoArrayLfnoPrimary;
    this.firstExpression = firstExpression;
    //this.lfArrayLfnoPrimaryList = lfArrayLfnoPrimaryList;
    this.expressionList = expressionList;
  }

  public LfnoPrimaryArrayAccess(Position start, Position end, AstNode parent,
                                LfnoArrayLfnoPrimary lfnoArrayLfnoPrimary,
                                Expression firstExpression,
                                //List<LfArrayLfnoPrimary> lfArrayLfnoPrimaryList,
                                List<Expression> expressionList) {
    super(start, end, parent);
    this.lfnoArrayLfnoPrimary = lfnoArrayLfnoPrimary;
    this.firstExpression = firstExpression;
    //this.lfArrayLfnoPrimaryList = lfArrayLfnoPrimaryList;
    this.expressionList = expressionList;
  }

  public LfnoPrimaryArrayAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                LfnoArrayLfnoPrimary lfnoArrayLfnoPrimary,
                                Expression firstExpression,
                                //List<LfArrayLfnoPrimary> lfArrayLfnoPrimaryList,
                                List<Expression> expressionList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.lfnoArrayLfnoPrimary = lfnoArrayLfnoPrimary;
    this.firstExpression = firstExpression;
    //this.lfArrayLfnoPrimaryList = lfArrayLfnoPrimaryList;
    this.expressionList = expressionList;
  }

  @JsonProperty("LfnoArrayLfnoPrimary")
  public LfnoArrayLfnoPrimary getLfnoArrayLfnoPrimary() {
    return lfnoArrayLfnoPrimary;
  }

  @JsonProperty("Expression")
  public Expression getFirstExpression() {
    return firstExpression;
  }

  @JsonProperty("ExpressionList")
  public List<Expression> getExpressionList() {
    return expressionList;
  }
}
