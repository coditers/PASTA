package codit.ast.pojos.packages;

import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class StaticImportOnDemandDeclaration extends ImportDeclaration {
  private final TypeName typeName;

  public StaticImportOnDemandDeclaration(Range range,
                                         TypeName typeName) {
    super(range);
    this.typeName = typeName;
  }

  public StaticImportOnDemandDeclaration(Position start, Position end,
                                         TypeName typeName) {
    super(start, end);
    this.typeName = typeName;
  }

  public StaticImportOnDemandDeclaration(int startLine, int startCol, int endLine, int endCol,
                                         TypeName typeName) {
    super(startLine, startCol, endLine, endCol);
    this.typeName = typeName;
  }
}
