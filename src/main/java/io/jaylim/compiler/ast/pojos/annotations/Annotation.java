package io.jaylim.compiler.ast.pojos.annotations;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.interfaces.ElementValue;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class Annotation extends AstNode implements ElementValue {

  public Annotation(Range range, AstNode parent) {
    super(range, parent);
  }

  public Annotation(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public Annotation(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }


}
