package codit.ast.pojos.expressions.primaries.methodreference;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import codit.ast.pojos.names.TypeName;
import codit.ast.pojos.types.TypeArguments;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class TypeSuperMethodReference extends MethodReference
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary {

  private final TypeName typeName;
  private final TypeArguments typeArguments;
  private final String identifier;

  public TypeSuperMethodReference(Range range, AstNode parent,
                                  TypeName typeName,
                                  TypeArguments typeArguments,
                                  String identifier) {
    super(range, parent);
    this.typeName = typeName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public TypeSuperMethodReference(Position start, Position end, AstNode parent,
                                  TypeName typeName,
                                  TypeArguments typeArguments,
                                  String identifier) {
    super(start, end, parent);
    this.typeName = typeName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }

  public TypeSuperMethodReference(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                  TypeName typeName,
                                  TypeArguments typeArguments,
                                  String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
    this.typeArguments = typeArguments;
    this.identifier = identifier;
  }
}
