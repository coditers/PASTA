package codit.ast.pojos.packages;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class StaticImportOnDemandDeclaration extends ImportDeclaration {
  private final TypeName typeName;

  public StaticImportOnDemandDeclaration(Range range, AstNode parent, TypeName typeName) {
    super(range, parent);
    this.typeName = typeName;
  }

  public StaticImportOnDemandDeclaration(Position start, Position end, AstNode parent, TypeName typeName) {
    super(start, end, parent);
    this.typeName = typeName;
  }

  public StaticImportOnDemandDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
  }

  @JsonProperty("TypeName")
  public TypeName getTypeName() {
    return typeName;
  }
}
