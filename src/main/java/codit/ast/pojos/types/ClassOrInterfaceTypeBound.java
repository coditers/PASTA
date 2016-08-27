package codit.ast.pojos.types;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ClassOrInterfaceTypeBound extends TypeBound {

  private final ClassOrInterfaceType classOrInterfaceType;
  private final List<InterfaceType> interfaceTypeList;

  public ClassOrInterfaceTypeBound(Range range, AstNode parent,
                                   ClassOrInterfaceType classOrInterfaceType,
                                   List<InterfaceType> interfaceTypeList) {
    super(range, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.interfaceTypeList = interfaceTypeList;
  }

  public ClassOrInterfaceTypeBound(Position start, Position end, AstNode parent,
                                   ClassOrInterfaceType classOrInterfaceType,
                                   List<InterfaceType> interfaceTypeList) {
    super(start, end, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.interfaceTypeList = interfaceTypeList;
  }

  public ClassOrInterfaceTypeBound(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   ClassOrInterfaceType classOrInterfaceType,
                                   List<InterfaceType> interfaceTypeList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.classOrInterfaceType = classOrInterfaceType;
    this.interfaceTypeList = interfaceTypeList;
  }

  @JsonProperty("ClassOrInterfaceType")
  public ClassOrInterfaceType getClassOrInterfaceType() {
    return classOrInterfaceType;
  }

  @JsonProperty("InterfaceTypeList")
  public List<InterfaceType> getInterfaceTypeList() {
    return interfaceTypeList;
  }
}
