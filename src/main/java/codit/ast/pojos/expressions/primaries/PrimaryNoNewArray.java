package codit.ast.pojos.expressions.primaries;

import java.util.List;

import codit.ast.AstNode;
import codit.ast.Position;
import codit.ast.Range;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfPrimary;
import codit.ast.pojos.expressions.primaries.interfaces.DefaultArrayLfnoPrimary;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class PrimaryNoNewArray extends Primary {

  private final DefaultArrayLfnoPrimary defaultArrayLfnoPrimary;

  private final List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList;

  public PrimaryNoNewArray(Range range, AstNode parent,
                           DefaultArrayLfnoPrimary defaultArrayLfnoPrimary,
                           List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList) {
    super(range, parent);
    this.defaultArrayLfnoPrimary = defaultArrayLfnoPrimary;
    this.defaultArrayLfPrimaryList = defaultArrayLfPrimaryList;
  }

  public PrimaryNoNewArray(Position start, Position end, AstNode parent,
                           DefaultArrayLfnoPrimary defaultArrayLfnoPrimary,
                           List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList) {
    super(start, end, parent);
    this.defaultArrayLfnoPrimary = defaultArrayLfnoPrimary;
    this.defaultArrayLfPrimaryList = defaultArrayLfPrimaryList;
  }

  public PrimaryNoNewArray(int startLine, int startCol, int endLine, int endCol, AstNode parent,
                           DefaultArrayLfnoPrimary defaultArrayLfnoPrimary,
                           List<DefaultArrayLfPrimary> defaultArrayLfPrimaryList) {
    super(startLine, startCol, endLine, endCol, parent);
    this.defaultArrayLfnoPrimary = defaultArrayLfnoPrimary;
    this.defaultArrayLfPrimaryList = defaultArrayLfPrimaryList;
  }
}