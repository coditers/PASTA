package codit.ast.pojos.classes;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.variables.VariableInitializer;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ArrayInitializer extends VariableInitializer {

  private final List<VariableInitializer> variableInitializerList;

  public ArrayInitializer(Range range, AstNode parent,
                          List<VariableInitializer> variableInitializerList) {
    super(range, parent);
    this.variableInitializerList = variableInitializerList;
  }

  public ArrayInitializer(Position start, Position end, AstNode parent,
                          List<VariableInitializer> variableInitializerList) {
    super(start, end, parent);
    this.variableInitializerList = variableInitializerList;
  }

  public ArrayInitializer(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                          List<VariableInitializer> variableInitializerList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.variableInitializerList = variableInitializerList;
  }
}
