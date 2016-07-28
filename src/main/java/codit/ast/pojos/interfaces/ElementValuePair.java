package codit.ast.pojos.interfaces;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.interfaces.ElementValue;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ElementValuePair extends AstNode {

  private final String identifier;
  private final ElementValue elementValue;

  public ElementValuePair(Range range, AstNode parent, String identifier, ElementValue elementValue) {
    super(range, parent);
    this.identifier = identifier;
    this.elementValue = elementValue;
  }

  public ElementValuePair(Position start, Position end, AstNode parent, String identifier, ElementValue elementValue) {
    super(start, end, parent);
    this.identifier = identifier;
    this.elementValue = elementValue;
  }

  public ElementValuePair(int startLine, int startCol, int endLine, int endCol, AstNode parent, String identifier, ElementValue elementValue) {
    super(startLine, startCol, endLine, endCol, parent);
    this.identifier = identifier;
    this.elementValue = elementValue;
  }
}
