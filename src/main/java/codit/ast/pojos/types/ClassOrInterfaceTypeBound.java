package codit.ast.pojos.types;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

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
}
