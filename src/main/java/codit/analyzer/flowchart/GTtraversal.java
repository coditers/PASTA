package codit.analyzer.flowchart;

/**
 * The type G ttraversal.
 */
public class GTtraversal {
  /**
   * Preorder.
   *
   * @param <E> the type parameter
   * @param rt  the rt
   */
  public static <E> void preorder(GTNode<E> rt) {

    //PARENT
    //executeOperation(rt);

    //CHILD
    if (!rt.isLeaf()) {
      GTNode<E> temp = rt.leftmostChild();
      while (temp != null) {
        preorder(temp);
        temp = temp.rightSibling();
      }
    }
  }

  /**
   * Postorder.
   *
   * @param <E> the type parameter
   * @param rt  the rt
   */
  public static <E> void postorder(GTNode<E> rt) {

    //CHILD
    if (!rt.isLeaf()) {
      GTNode<E> temp = rt.leftmostChild();
      while (temp != null) {
        postorder(temp);
        temp = temp.rightSibling();
      }
    }

    //PARENT
    //executeOperation(rt);
  }
}
