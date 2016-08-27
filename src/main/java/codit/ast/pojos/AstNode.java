package codit.ast.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import codit.ast.visitor.AstBaseVisitor;

/**
 * Created by Jisung on 7/19/2016.
 */
public abstract class AstNode implements ParseTree{

  @JsonIgnore
  private final Range range;


  @JsonIgnore
  private AstNode parent;

  /** Constructors */
  public AstNode(Range range, AstNode parent) {
    this.range = range;
    this.parent = parent;
  }

  public AstNode(Position start, Position end, AstNode parent) {
    this.range = new Range(start, end);
    this.parent = parent;
  }


  public AstNode(int startLine, int startCol, int endLine, int endCol, AstNode parent) {
    this.range = new Range(startLine, startCol, endLine, endCol);
    this.parent = parent;
  }

  /** Getter and Setter */
  public Range getRange() {
    return range;
  }

  public AstNode getParent() {
    return parent;
  }

  public void setParent(AstNode parent) {
    this.parent = parent;
  }

  /** Accept method for visitor pattern */
  public void accept(AstBaseVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof AstNode)) return false;

    AstNode astNode = (AstNode) o;

    return parent != null ? parent.equals(astNode.parent) : astNode.parent == null;

  }

  @Override
  public int hashCode() {
    return parent != null ? parent.hashCode() : 0;
  }
}
