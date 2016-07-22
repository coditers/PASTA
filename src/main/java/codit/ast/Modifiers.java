package codit.ast;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class Modifiers {

  // Access Modifiers

  public static final int PUBLIC        = 0x00000001;

  public static final int PRIVATE       = 0x00000002;

  public static final int PROTECTED     = 0x00000004;


  // Non Access Modifiers

  /**
   * static can be applied for methods and variables.
   * A method or variable marked as static belongs to class file.
   * A static member should be accessed using the class name.
   * <ul>
   *   <li>The static variable and static methods are called class members.</li>
   *   <li>A method marked as static can only access other static methods and
   *   variables directly.</li>
   *   <li>To access the instance variables and methods, a static method should have
   *   an instance on which the object members should be invoked.
   *   </li>
   *   <li>Any instance can access the static variables and can change them. But, the
   *   changes will reflect for all the objects.
   *   </li>
   *   <li>Members marked as static can be final.</li>
   * </ul>
   *
   */
  public static final int STATIC        = 0x00000008;

  /**
   * final can be applied for classes, methods, instance variables, local variables.
   * <ul>
   *   <li> A class marked as final cannot be extended.</li>
   *   <li> A method marked with final cannot be overridden.</li>
   *   <li> A primitive data type or an object reference will not
   *   change its value or object when marked final.</li>
   * </ul>
   *
   * You can use final modifier when the class, method, or variable are expected to
   * never be changed.
   */
  public static final int FINAL         = 0x00000010;


  public static final int SYNCHRONIZED  = 0x00000020;

  public static final int VOLATILE      = 0x00000040;

  public static final int TRANSIENT     = 0x00000080;

  public static final int NATIVE        = 0x00000100;

  public static final int ABSTRACT      = 0x00000400;

  public static final int STRICTFP      = 0x00000800;


  public static boolean isPublic(int mask) {
    return (PUBLIC & mask) != 0;
  }
  public static boolean isPrivate(int mask) {
    return (PRIVATE & mask) != 0;
  }
  public static boolean isProtected(int mask) {
    return (PROTECTED & mask) != 0;
  }

  public static boolean isStatic(int mask) {
    return (STATIC & mask) != 0;
  }
  public static boolean isFinal(int mask) {
    return (FINAL & mask) != 0;
  }
  public static boolean isSynchronized(int mask) {
    return (SYNCHRONIZED & mask) != 0;
  }
  public static boolean isVolatile(int mask) {
    return (VOLATILE & mask) != 0;
  }
  public static boolean isTransient(int mask) {
    return (TRANSIENT & mask) != 0;
  }
  public static boolean isNative(int mask) {
    return (NATIVE & mask) != 0;
  }
  public
  public static boolean isAbstract() {

  }
}
