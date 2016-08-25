package codit.analyzer.flowchart;

/**
 * Jisung 10/6/2016 Node-based General Tree Implementation. Interface for General Tree ADT
 *
 * @param <E> Element value of a node
 */
public interface GenTree<E> {
  /**
   * Documented by Lim, 10/6/2016 Re-initialize the tree.
   */
  void clear();

  /**
   * Documented by Lim, 10/6/2016 Root gt node.
   *
   * @return The root of the tree
   */
  GTNode<E> root();

  /**
   * Documented by Lim, 10/6/2016 Make the tree have a new root, give first child and siblings.
   *
   * @param value the value of the element
   * @param first the first child of new root
   * @param sib   the next sibling
   */
  void newroot(E value, GTNode<E> first, GTNode<E> sib);

  /**
   * Documented by Lim, 10/6/2016 Mate the root of the tree have a left child.
   *
   * @param value the value
   */
  void newleftchild(E value);

}
