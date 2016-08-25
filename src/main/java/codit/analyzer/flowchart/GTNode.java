package codit.analyzer.flowchart;

/*
 * 
 */

/**
 * Node-based General Tree Implementation. Interface for General Tree node ADT
 *
 * @param <E> Element value of a node
 */
public interface GTNode<E> {

  public E value();

  public void setValue();

  public GTNode<E> parent();

  public void getParent();

  public boolean isLeaf();

  public GTNode<E> leftmostChild();

  public void insertFirst();

  public void removeFirst();

  public GTNode<E> rightSibling();

  public void isnertNext();

  public void removeNext();
}
