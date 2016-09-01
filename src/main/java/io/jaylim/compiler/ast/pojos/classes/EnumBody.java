package io.jaylim.compiler.ast.pojos.classes;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class EnumBody extends AstNode {

  private final List<EnumConstant> enumConstantList;

  private final List<ClassBodyDeclaration> enumBodyDeclarationList;

  public EnumBody(Range range, AstNode parent,
                  List<EnumConstant> enumConstantList,
                  List<ClassBodyDeclaration> enumBodyDeclarationList) {
    super(range, parent);
    this.enumConstantList = enumConstantList;
    this.enumBodyDeclarationList = enumBodyDeclarationList;
  }

  public EnumBody(Position start, Position end, AstNode parent,
                  List<EnumConstant> enumConstantList,
                  List<ClassBodyDeclaration> enumBodyDeclarationList) {
    super(start, end, parent);
    this.enumConstantList = enumConstantList;
    this.enumBodyDeclarationList = enumBodyDeclarationList;
  }

  public EnumBody(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                  List<EnumConstant> enumConstantList,
                  List<ClassBodyDeclaration> enumBodyDeclarationList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.enumConstantList = enumConstantList;
    this.enumBodyDeclarationList = enumBodyDeclarationList;
  }

  @JsonProperty("EnumConstantList")
  public List<EnumConstant> getEnumConstantList() {
    return enumConstantList;
  }

  @JsonProperty("EnumBodyDeclarationList")
  public List<ClassBodyDeclaration> getEnumBodyDeclarationList() {
    return enumBodyDeclarationList;
  }
}
