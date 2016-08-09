package codit.ast.pojos.packages;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public abstract class ImportDeclaration extends AstNode {
  public ImportDeclaration(Range range, AstNode parent) {
    super(range, parent);
  }

  public ImportDeclaration(Position start, Position end, AstNode parent) {
    super(start, end, parent);
  }

  public ImportDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    super(startLine, startCol, endLine, endCol, parent);
  }
}
