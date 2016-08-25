package codit.ast.pojos.classes.constructors;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;
import codit.ast.pojos.parameters.MultiFormalParameterList;
import codit.ast.pojos.types.TypeParameter;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ConstructorDeclarator extends AstNode {

  private final List<TypeParameter> typeParameterList;
  private final String identifier;
  private final MultiFormalParameterList formalParameterList;

  public ConstructorDeclarator(Range range, AstNode parent,
                               List<TypeParameter> typeParameterList,
                               String identifier,
                               MultiFormalParameterList formalParameterList) {
    super(range, parent);
    this.typeParameterList = typeParameterList;
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
  }

  public ConstructorDeclarator(Position start, Position end, AstNode parent,
                               List<TypeParameter> typeParameterList,
                               String identifier,
                               MultiFormalParameterList formalParameterList) {
    super(start, end, parent);
    this.typeParameterList = typeParameterList;
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
  }

  public ConstructorDeclarator(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                               List<TypeParameter> typeParameterList,
                               String identifier,
                               MultiFormalParameterList formalParameterList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.typeParameterList = typeParameterList;
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
  }
}
