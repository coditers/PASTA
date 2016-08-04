package codit.ast.pojos.types;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * Newly added method.
 * @author Jisung Lim <iejisung@gmail.com>
 * @version 2.0
 * TODO - Change {@code List<TypeArgument> } to {@code TypeArguments }
 */
public class TypeArguments extends TypeArgumentsOrDiamond {

  private final List<TypeArgument> typeArgumentList;

  public TypeArguments(Range range, AstNode parent, List<TypeArgument> typeArgumentList) {
    super(range, parent);
    this.typeArgumentList = typeArgumentList;
  }

  public TypeArguments(Position start, Position end, AstNode parent, List<TypeArgument> typeArgumentList) {
    super(start, end, parent);
    this.typeArgumentList = typeArgumentList;
  }

  public TypeArguments(int startLine, int startCol, int endLine, int endCol, AstNode parent, List<TypeArgument> typeArgumentList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeArgumentList = typeArgumentList;
  }
}
