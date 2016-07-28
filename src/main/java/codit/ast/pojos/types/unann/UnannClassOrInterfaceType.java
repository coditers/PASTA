package codit.ast.pojos.types.unann;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannClassOrInterfaceType extends UnannReferenceType implements UnannArrayable {
  private final boolean isInterface;
  private final UnannUnitClassOrInterfaceType unannUnitClassOrInterfaceType;   // Target class
  private final List<UnannUnitClassOrInterfaceType> unannClassOrInterfaceType; // Packaging class

  public UnannClassOrInterfaceType(Range range, AstNode parent,
                                   boolean isInterface,
                                   UnannUnitClassOrInterfaceType unannUnitClassOrInterfaceType,
                                   List<UnannUnitClassOrInterfaceType> unannClassOrInterfaceType) {
    super(range, parent);
    this.isInterface = isInterface;
    this.unannUnitClassOrInterfaceType = unannUnitClassOrInterfaceType;
    this.unannClassOrInterfaceType = unannClassOrInterfaceType;
  }

  public UnannClassOrInterfaceType(Position start, Position end, AstNode parent,
                                   boolean isInterface,
                                   UnannUnitClassOrInterfaceType unannUnitClassOrInterfaceType,
                                   List<UnannUnitClassOrInterfaceType> unannClassOrInterfaceType) {
    super(start, end, parent);
    this.isInterface = isInterface;
    this.unannUnitClassOrInterfaceType = unannUnitClassOrInterfaceType;
    this.unannClassOrInterfaceType = unannClassOrInterfaceType;
  }

  public UnannClassOrInterfaceType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                   boolean isInterface,
                                   UnannUnitClassOrInterfaceType unannUnitClassOrInterfaceType,
                                   List<UnannUnitClassOrInterfaceType> unannClassOrInterfaceType) {
    super(startLine, startCol, endLine, endCol, parent);
    this.isInterface = isInterface;
    this.unannUnitClassOrInterfaceType = unannUnitClassOrInterfaceType;
    this.unannClassOrInterfaceType = unannClassOrInterfaceType;
  }
}
