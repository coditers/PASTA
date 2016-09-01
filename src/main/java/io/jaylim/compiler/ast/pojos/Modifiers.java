package io.jaylim.compiler.ast.pojos;

/**
 *
 * @author Jisung Lim ( iejisung@gmail.com )
 * @since July, 2016.
 */
public class Modifiers {

  // Access Modifiers
  public static final int NONE          = 0x00000000;

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

  public static final int DEFAULT       = 0x00010000;

  // Access Modifiers
  public static boolean isNone(int mask) {
    return (0x00000007 & mask) == 0;
  }
  public static boolean isPublic(int mask) {
    return (PUBLIC & mask) != 0;
  }
  public static boolean isPrivate(int mask) {
    return (PRIVATE & mask) != 0;
  }
  public static boolean isProtected(int mask) {
    return (PROTECTED & mask) != 0;
  }

  // Non-access Modifiers
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
  public static boolean isAbstract(int mask) {
    return (ABSTRACT & mask) != 0;
  }
  public static boolean isStrictfp(int mask) {
    return (STRICTFP & mask) != 0;
  }



  private static final int CLASS_MODIFIERS =
      Modifiers.PUBLIC         | Modifiers.PROTECTED    | Modifiers.PRIVATE |
      Modifiers.ABSTRACT       | Modifiers.STATIC       | Modifiers.FINAL   |
      Modifiers.STRICTFP;

  private static final int CONSTRUCTOR_MODIFIERS =
      Modifiers.PUBLIC         | Modifiers.PROTECTED    | Modifiers.PRIVATE;

  private static final int METHOD_MODIFIERS =
      Modifiers.PUBLIC         | Modifiers.PROTECTED    | Modifiers.PRIVATE |
      Modifiers.ABSTRACT       | Modifiers.STATIC       | Modifiers.FINAL   |
      Modifiers.SYNCHRONIZED   | Modifiers.NATIVE       | Modifiers.STRICTFP;

  private static final int FIELD_MODIFIERS =
      Modifiers.PUBLIC         | Modifiers.PROTECTED    | Modifiers.PRIVATE |
      Modifiers.STATIC         | Modifiers.FINAL        | Modifiers.TRANSIENT |
      Modifiers.VOLATILE;


  private static final int INTERFACE_MODIFIERS =
      Modifiers.PUBLIC         | Modifiers.PROTECTED    | Modifiers.PRIVATE |
      Modifiers.ABSTRACT       | Modifiers.STATIC       | Modifiers.STRICTFP;

  private static final int INTERFACE_METHOD_MODIFIERS =
      Modifiers.PUBLIC         | Modifiers.ABSTRACT     | Modifiers.STATIC  |
      Modifiers.STRICTFP;

  private static final int INTERFACE_CONSTANT_MODIFIERS =
      Modifiers.PUBLIC         | Modifiers.STATIC       | Modifiers.FINAL;


  //
  private static final int PARAMETER_MODIFIERS =
      Modifiers.FINAL;


  //
  static final int ACCESS_MODIFIERS =
      Modifiers.PUBLIC | Modifiers.PROTECTED | Modifiers.PRIVATE;


  public static int classModifiers() { return CLASS_MODIFIERS; }
  public static int constructorModifiers() { return CONSTRUCTOR_MODIFIERS; }
  public static int methodModifiers() { return METHOD_MODIFIERS; }
  public static int fieldModifiers() { return FIELD_MODIFIERS; }
  public static int interfaceModifiers() { return INTERFACE_MODIFIERS; }
  public static int interfaceMethodModifers() { return INTERFACE_METHOD_MODIFIERS; }
  public static int interfaceConstantModifiers() { return INTERFACE_CONSTANT_MODIFIERS; }
  public static int parameterModifiers() { return PARAMETER_MODIFIERS; }
  public static int accessModifiers() { return ACCESS_MODIFIERS; }



  public static boolean isClassModifiers(int mask) {
    return ( (~CLASS_MODIFIERS) & mask) == 0;
  }
  public static boolean isConstructorModifiers(int mask) {
    return ( (~CONSTRUCTOR_MODIFIERS) & mask) == 0;
  }
  public static boolean isMethodModifiers(int mask) {
    return ( (~METHOD_MODIFIERS) & mask) == 0;
  }
  public static boolean isFieldModifiers(int mask) {
    return ( (~FIELD_MODIFIERS) & mask) == 0;
  }
  public static boolean isInterfaceModifiers(int mask) {
    return ( (~INTERFACE_MODIFIERS) & mask) == 0;
  }
  public static boolean isInterfaceMethodModifiers(int mask) {
    return ( (~INTERFACE_METHOD_MODIFIERS) & mask) == 0;
  }
  public static boolean isInterfaceConstantModifiers(int mask) {
    return ( (~INTERFACE_CONSTANT_MODIFIERS) & mask) == 0;
  }
  public static boolean isParameterModifiers(int mask) {
    return ( (~PARAMETER_MODIFIERS) & mask) == 0;
  }


}
