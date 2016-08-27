package codit.ast.pojos.classes;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
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

  @JsonProperty("UnannType")
  public UnannType getUnannType() {
    return unannType;
  }
}