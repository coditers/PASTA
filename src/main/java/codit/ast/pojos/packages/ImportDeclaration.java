package codit.ast.pojos.packages;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ImportDeclaration extends AstNode {

  public ImportDeclaration(Range range) {
    super(range);
  }

  public ImportDeclaration(Position start, Position end) {
    super(start, end);
  }

  public ImportDeclaration(int startLine, int startCol, int endLine, int endCol) {
    super(startLine, startCol, endLine, endCol);
  }
}
