package io.jaylim.compiler.ast.pojos.literals;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class CharacterLiteral extends Literal {

  // private final char val;

  public CharacterLiteral(Range range, AstNode parent, String rawString) {
    super(range, parent, rawString);
    // this.val = parseChar(rawString);
  }

  public CharacterLiteral(Position start, Position end, AstNode parent, String rawString) {
    super(start, end, parent, rawString);
    // this.val = parseChar(rawString);
  }

  public CharacterLiteral(int startLine, int startCol, int endLine, int endCol, AstNode parent, String rawString) {
    super(startLine, startCol, endLine, endCol, parent, rawString);
    // this.val = parseChar(rawString);
  }


  // public char parseChar(String rawString) { }

  // public char getValue() {}


}