package codit.ast.pojos.packages;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.names.PackageOrTypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeImportOnDemandDeclaration extends ImportDeclaration {
  private final PackageOrTypeName packageOrTypeName;

  public TypeImportOnDemandDeclaration(Range range, AstNode parent, PackageOrTypeName packageOrTypeName) {
    super(range, parent);
    this.packageOrTypeName = packageOrTypeName;
  }

  public TypeImportOnDemandDeclaration(Position start, Position end, AstNode parent, PackageOrTypeName packageOrTypeName) {
    super(start, end, parent);
    this.packageOrTypeName = packageOrTypeName;
  }

  public TypeImportOnDemandDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent, PackageOrTypeName packageOrTypeName) {
    super(startLine, startCol, endLine, endCol, parent);
    this.packageOrTypeName = packageOrTypeName;
  }
}
