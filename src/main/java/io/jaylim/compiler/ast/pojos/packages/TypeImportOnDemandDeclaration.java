package io.jaylim.compiler.ast.pojos.packages;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.names.PackageOrTypeName;

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

  @JsonProperty("PackageOrTypeName")
  public PackageOrTypeName getPackageOrTypeName() {
    return packageOrTypeName;
  }
}
