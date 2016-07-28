package codit.ast.pojos.interfaces;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ElementValueArrayInitializer extends AstNode implements ElementValue {

  private final List<ElementValue> elementValueListList;

  public ElementValueArrayInitializer(Range range, AstNode parent,
                                      List<ElementValue> elementValueListList) {
    super(range, parent);
    this.elementValueListList = elementValueListList;
  }

  public ElementValueArrayInitializer(Position start, Position end, AstNode parent,
                                      List<ElementValue> elementValueListList) {
    super(start, end, parent);
    this.elementValueListList = elementValueListList;
  }

  public ElementValueArrayInitializer(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                                      List<ElementValue> elementValueListList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.elementValueListList = elementValueListList;
  }
}
