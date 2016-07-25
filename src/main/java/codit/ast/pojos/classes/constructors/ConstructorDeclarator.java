package codit.ast.pojos.classes.constructors;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.parameters.FormalParameterList;
import codit.ast.pojos.types.TypeParameter;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ConstructorDeclarator extends AstNode {

  private final List<TypeParameter> typeParameterList;
  private final String identifier;
  private final FormalParameterList formalParameterList;

  public ConstructorDeclarator(Range range, AstNode parent,
                               List<TypeParameter> typeParameterList,
                               String identifier,
                               FormalParameterList formalParameterList) {
    super(range, parent);
    this.typeParameterList = typeParameterList;
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
  }

  public ConstructorDeclarator(Position start, Position end, AstNode parent,
                               List<TypeParameter> typeParameterList,
                               String identifier,
                               FormalParameterList formalParameterList) {
    super(start, end, parent);
    this.typeParameterList = typeParameterList;
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
  }

  public ConstructorDeclarator(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                               List<TypeParameter> typeParameterList,
                               String identifier,
                               FormalParameterList formalParameterList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeParameterList = typeParameterList;
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
  }
}
