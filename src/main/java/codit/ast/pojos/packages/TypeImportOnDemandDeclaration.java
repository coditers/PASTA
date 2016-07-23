package codit.ast.pojos.packages;

import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.names.PackageOrTypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeImportOnDemandDeclaration extends ImportDeclaration {
  private final PackageOrTypeName packageOrTypeName;

  public TypeImportOnDemandDeclaration(Range range,
                                         PackageOrTypeName packageOrTypeName) {
    super(range);
    this.packageOrTypeName = packageOrTypeName;
  }

  public TypeImportOnDemandDeclaration(Position start, Position end,
                                         PackageOrTypeName packageOrTypeName) {
    super(start, end);
    this.packageOrTypeName = packageOrTypeName;
  }

  public TypeImportOnDemandDeclaration(int startLine, int startCol, int endLine, int endCol,
                                         PackageOrTypeName packageOrTypeName) {
    super(startLine, startCol, endLine, endCol);
    this.packageOrTypeName = packageOrTypeName;
  }
}
