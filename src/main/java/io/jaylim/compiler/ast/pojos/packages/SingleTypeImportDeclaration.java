package io.jaylim.compiler.ast.pojos.packages;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.names.TypeName;

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

  @JsonProperty("TypeName")
  public TypeName getTypeName() {
    return typeName;
  }
}
