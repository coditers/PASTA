package codit.ast.pojos.packages;

import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SingleStaticImportDeclaration extends ImportDeclaration {
  private final TypeName typeName;
  private final String identifer;

  public SingleStaticImportDeclaration(Range range,
                                       TypeName typeName,
                                       String identifer) {
    super(range);
    this.typeName = typeName;
    this.identifer = identifer;
  }

  public SingleStaticImportDeclaration(Position start, Position end,
                                       TypeName typeName,
                                       String identifer) {
    super(start, end);
    this.typeName = typeName;
    this.identifer = identifer;
  }

  public SingleStaticImportDeclaration(int startLine, int startCol, int endLine, int endCol,
                                       TypeName typeName,
                                       String identifer) {
    super(startLine, startCol, endLine, endCol);
    this.typeName = typeName;
    this.identifer = identifer;
  }
}
