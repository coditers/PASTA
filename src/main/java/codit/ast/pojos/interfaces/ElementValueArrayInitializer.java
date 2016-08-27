package codit.ast.pojos.interfaces;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import codit.ast.pojos.AstNode;
import codit.ast.pojos.Position;
import codit.ast.pojos.Range;

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

  @JsonProperty("ElementValueListList")
  public List<ElementValue> getElementValueListList() {
    return elementValueListList;
  }
}
