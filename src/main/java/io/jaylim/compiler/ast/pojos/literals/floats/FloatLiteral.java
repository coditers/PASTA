package io.jaylim.compiler.ast.pojos.literals.floats;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.literals.Literal;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class FloatLiteral extends Literal {

  // TODO - Additional Field Variable
  // private final boolean isDouble;
  // private final float value;


  public FloatLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
    // this.isDouble = isDouble(rawString);
    // this.value = parseFloat(rawString);
  }

  public FloatLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
    // this.isDouble = isDouble(rawString);
    // this.value = parseFloat(rawString);
  }

  public FloatLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
    // this.isDouble = isDouble(rawString);
    // this.value = parseFloat(rawString);
  }

  // TODO - Semantic step
  // public boolean isDouble(String rs) { return !rs.endsWith("F") && !rs.endsWith("f"); }
  // public abstract float parseFloat(String rawString);

  // TODO - Getter for field variable
  // public boolean isDouble() { return isDouble; }
  // public int getValue() { return value; }

}
