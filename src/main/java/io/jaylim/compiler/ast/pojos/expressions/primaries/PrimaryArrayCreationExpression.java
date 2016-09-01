package io.jaylim.compiler.ast.pojos.expressions.primaries;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.primaries.arraycreationexpression.ArrayCreationExpression;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimaryArrayCreationExpression extends Primary {

  private final ArrayCreationExpression arrayCreationExpression;

  private final List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList;

  public PrimaryArrayCreationExpression(Range range, AstNode parent,
                                        ArrayCreationExpression arrayCreationExpression,
                                        List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList) {
    super(range, parent);
    this.arrayCreationExpression = arrayCreationExpression;
    this.defaultArrayLfPrimaryList = defaultArrayLfPrimaryList;
  }

  public PrimaryArrayCreationExpression(Position start, Position end, AstNode parent,
                                        ArrayCreationExpression arrayCreationExpression,
                                        List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList) {
    super(start, end, parent);
    this.arrayCreationExpression = arrayCreationExpression;
    this.defaultArrayLfPrimaryList = defaultArrayLfPrimaryList;
  }

  public PrimaryArrayCreationExpression(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                        ArrayCreationExpression arrayCreationExpression,
                                        List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.arrayCreationExpression = arrayCreationExpression;
    this.defaultArrayLfPrimaryList = defaultArrayLfPrimaryList;
  }

  @JsonProperty("ArrayCreationExpression")
  public ArrayCreationExpression getArrayCreationExpression() {
    return arrayCreationExpression;
  }

  @JsonProperty("DefaultArrayLfPrimaryList")
  public List<DefaultArrayLfPrimary> getDefaultArrayLfPrimaryList() {
    return defaultArrayLfPrimaryList;
  }
}
