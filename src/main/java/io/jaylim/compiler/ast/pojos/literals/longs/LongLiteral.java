package io.jaylim.compiler.ast.pojos.literals.longs;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.literals.Literal;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class LongLiteral extends Literal {

  // TODO -Additional Field Variable
  // private final long value;

  public LongLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
    // this.value = parseLong(rawString);
  }

  public LongLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
    // this.value = parseLong(rawString);
  }

  public LongLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
    // this.value = parseLong(rawString);
  }

  // TODO - Semantic step
  // public abstract long parseLong(String rawString);

  // TODO - Getter for field variable
  // public long getValue(){}
}
