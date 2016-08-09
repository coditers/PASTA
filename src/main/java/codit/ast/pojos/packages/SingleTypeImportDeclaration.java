package codit.ast.pojos.packages;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SingleTypeImportDeclaration extends ImportDeclaration {
  private final TypeName typeName;

  public SingleTypeImportDeclaration(Range range, AstNode parent, TypeName typeName) {
    super(range, parent);
    this.typeName = typeName;
  }

  public SingleTypeImportDeclaration(Position start, Position end, AstNode parent, TypeName typeName) {
    super(start, end, parent);
    this.typeName = typeName;
  }

  public SingleTypeImportDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
  }
}
