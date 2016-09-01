package io.jaylim.compiler.ast.pojos.literals.doubles;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.literals.Literal;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class DoubleLiteral extends Literal {

  // TODO
  // private final double val;

  public DoubleLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
    // this.val = parseDouble(rawString);
  }

  public DoubleLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
    // this.val = parseDouble(rawString);
  }

  public DoubleLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
    // this.val = parseDouble(rawString);
  }


  // TODO
  // public abstract double parseDouble(String rawString);
}
