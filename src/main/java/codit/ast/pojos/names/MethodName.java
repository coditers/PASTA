package codit.ast.pojos.names;

import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MethodName extends Name {
  public MethodName(Range range,
                    String identifier) {
    super(range, identifier);
  }

  public MethodName(Position start, Position end,
                    String identifier) {
    super(start, end, identifier);
  }

  public MethodName(int startLine, int startCol, int endLine, int endCol,
                    String identifier) {
    super(startLine, startCol, endLine, endCol, identifier);
  }
}
