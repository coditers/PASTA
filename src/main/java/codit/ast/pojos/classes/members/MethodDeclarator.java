package codit.ast.pojos.classes.members;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.parameters.FormalParameterList;
import codit.ast.pojos.types.Dims;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class MethodDeclarator extends AstNode {

  private final String identifier;
  private final FormalParameterList formalParameterList;
  private final Dims dims;

  public MethodDeclarator(Range range, AstNode parent,
                          String identifier,
                          FormalParameterList formalParameterList,
                          Dims dims) {
    super(range, parent);
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
    this.dims = dims;
  }

  public MethodDeclarator(Position start, Position end, AstNode parent,
                          String identifier,
                          FormalParameterList formalParameterList,
                          Dims dims) {
    super(start, end, parent);
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
    this.dims = dims;
  }

  public MethodDeclarator(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                          String identifier,
                          FormalParameterList formalParameterList,
                          Dims dims) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
    this.formalParameterList = formalParameterList;
    this.dims = dims;
  }
}
