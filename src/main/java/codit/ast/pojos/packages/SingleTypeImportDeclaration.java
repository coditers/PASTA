package codit.ast.pojos.packages;

import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SingleTypeImportDeclaration extends ImportDeclaration {
  private final TypeName typeName;

  public SingleTypeImportDeclaration(Range range,
                                         TypeName typeName) {
    super(range);
    this.typeName = typeName;
  }

  public SingleTypeImportDeclaration(Position start, Position end,
                                         TypeName typeName) {
    super(start, end);
    this.typeName = typeName;
  }

  public SingleTypeImportDeclaration(int startLine, int startCol, int endLine, int endCol,
                                         TypeName typeName) {
    super(startLine, startCol, endLine, endCol);
    this.typeName = typeName;
  }
}
