package codit.ast.pojos.classes;

import java.util.List;

import codit.ast.pojos.types.ClassType;
import codit.ast.pojos.types.InterfaceType;
import codit.ast.pojos.types.TypeParameter;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class NormalClassDeclaration extends ClassDeclaration {

  private final ClassModifier classModifier;

  private final String identifier;
  private final List<TypeParameter> typeParameterList;

  private final ClassType superClass;
  private final List<InterfaceType> superInterfaceList;

  private final ClassBody classBody;
}
