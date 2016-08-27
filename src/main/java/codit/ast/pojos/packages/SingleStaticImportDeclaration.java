package codit.ast.pojos.packages;

import com.fasterxml.jackson.annotation.JsonProperty;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SingleStaticImportDeclaration extends ImportDeclaration {
  private final TypeName typeName;
  private final String identifer;

  public SingleStaticImportDeclaration(Range range, AstNode parent, TypeName typeName, String identifer) {
    super(range, parent);
    this.typeName = typeName;
    this.identifer = identifer;
  }

  public SingleStaticImportDeclaration(Position start, Position end, AstNode parent, TypeName typeName, String identifer) {
    super(start, end, parent);
    this.typeName = typeName;
    this.identifer = identifer;
  }

  public SingleStaticImportDeclaration(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName, String identifer) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
    this.identifer = identifer;
  }

  @JsonProperty("TypeName")
  public TypeName getTypeName() {
    return typeName;
  }

  @JsonProperty("Identifer")
  public String getIdentifer() {
    return identifer;
  }
}
