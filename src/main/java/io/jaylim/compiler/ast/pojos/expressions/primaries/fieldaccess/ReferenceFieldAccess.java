package io.jaylim.compiler.ast.pojos.expressions.primaries.fieldaccess;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Position;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.pojos.expressions.assignments.LeftHandSide;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayDefaultPrimary;
import io.jaylim.compiler.ast.pojos.expressions.primaries.interfaces.LfnoArrayLfnoPrimary;
import io.jaylim.compiler.ast.pojos.names.TypeName;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ReferenceFieldAccess extends FieldAccess
    implements DefaultArrayDefaultPrimary, DefaultArrayLfnoPrimary,
    LfnoArrayDefaultPrimary, LfnoArrayLfnoPrimary, LeftHandSide {

  private final TypeName typeName;
  private final String identifier;

  public ReferenceFieldAccess(Range range, AstNode parent, TypeName typeName, String identifier) {
    super(range, parent);
    this.typeName = typeName;
    this.identifier = identifier;
  }

  public ReferenceFieldAccess(Position start, Position end, AstNode parent, TypeName typeName, String identifier) {
    super(start, end, parent);
    this.typeName = typeName;
    this.identifier = identifier;
  }

  public ReferenceFieldAccess(int startLine, int startCol, int endLine, int endCol, AstNode parent, TypeName typeName, String identifier) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeName = typeName;
    this.identifier = identifier;
  }

  @JsonProperty("TypeName")
  public TypeName getTypeName() {
    return typeName;
  }

  @JsonProperty("Identifier")
  public String getIdentifier() {
    return identifier;
  }
}
