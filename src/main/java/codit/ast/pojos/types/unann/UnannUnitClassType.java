package codit.ast.pojos.types.unann;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.types.TypeArgument;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class UnannUnitClassType extends UnannUnitClassOrInterfaceType {

  private final String identifier;

  private final List<TypeArgument> typeArgumentList;

  public UnannUnitClassType(Range range, AstNode parent,
                            String identifier,
                            List<TypeArgument> typeArgumentList) {
    super(range, parent);
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  public UnannUnitClassType(Position start, Position end, AstNode parent,
                            String identifier,
                            List<TypeArgument> typeArgumentList) {
    super(start, end, parent);
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }

  public UnannUnitClassType(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                            String identifier,
                            List<TypeArgument> typeArgumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
    this.typeArgumentList = typeArgumentList;
  }
}
