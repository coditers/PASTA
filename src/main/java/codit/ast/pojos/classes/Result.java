package codit.ast.pojos.classes;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.types.unann.UnannType;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Result extends AstNode {

  private final UnannType unannType;

  public Result(Range range, AstNode parent, UnannType unannType) {
    super(range, parent);
    this.unannType = unannType;
  }

  public Result(Position start, Position end, AstNode parent, UnannType unannType) {
    super(start, end, parent);
    this.unannType = unannType;
  }

  public Result(int startLine, int startCol, int endLine, int endCol, AstNode parent, UnannType unannType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.unannType = unannType;
  }


}