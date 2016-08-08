package codit.ast.visitor;

import codit.ast.AstNode;
import codit.ast.pojos.literals.BooleanLiteral;
import codit.ast.pojos.literals.CharacterLiteral;
import codit.ast.pojos.literals.Literal;
import codit.ast.pojos.literals.NullLiteral;
import codit.ast.pojos.literals.StringLiteral;
import codit.ast.pojos.literals.floats.DecimalFloatLiteral;
import codit.ast.pojos.literals.floats.FloatLiteral;
import codit.ast.pojos.literals.floats.HexFloatLiteral;
import codit.ast.pojos.literals.integers.BinaryIntegerLiteral;
import codit.ast.pojos.literals.integers.DecimalIntegerLiteral;
import codit.ast.pojos.literals.integers.HexIntegerLiteral;
import codit.ast.pojos.literals.integers.IntegerLiteral;
import codit.ast.pojos.literals.integers.OctalIntegerLiteral;
import codit.ast.pojos.names.AmbiguousName;
import codit.ast.pojos.names.ExpressionName;
import codit.ast.pojos.names.MethodName;
import codit.ast.pojos.names.Name;
import codit.ast.pojos.names.PackageOrTypeName;
import codit.ast.pojos.names.TypeName;
import codit.ast.pojos.variables.VariableDeclarator;
import codit.ast.pojos.variables.VariableDeclaratorId;
import codit.ast.pojos.variables.VariableInitializer;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public interface AstVisitor<T> extends NodeVisitor<T> {

  /**
   * Visit specific node in Abstract Syntax Tree, and
   * then execute {@link AstNode#accept} method.
   *
   * @param astNode The Node of Abstract Syntax Tree.
   * @return The visiting result T.
   */
  T visitSomething(AstNode astNode);


  /** Literal Node */
  T visit(Literal literal);

  // Float Literal Node
  T visit(FloatLiteral floatLiteral);

  T visit(DecimalFloatLiteral decimalFloatLiteral);
  T visit(HexFloatLiteral hexFloatLiteral);

  // Integer Literal Node
  T visit(IntegerLiteral integerLiteral);

  T visit(BinaryIntegerLiteral binaryIntegerLiteral);
  T visit(OctalIntegerLiteral octalIntegerLiteral);
  T visit(DecimalIntegerLiteral decimalIntegerLiteral);
  T visit(HexIntegerLiteral hexIntegerLiteral);

  // Character Literal Node
  T visit(CharacterLiteral characterLiteral);

  // String Literal Node
  T visit(StringLiteral stringLiteral);

  // Boolean Literal Node
  T visit(BooleanLiteral booleanLiteral);

  // Null Literal Node
  T visit(NullLiteral nullLiteral);

  /** Variable Declaration Node */
  // Variable Declarator ->  Id ( '=' Initializer )?
  T visit(VariableDeclarator variableDeclarator);

  // Variable Declarator Id
  T visit(VariableDeclaratorId variableDeclaratorId);

  // Variable Initializer
  T visit(VariableInitializer variableInitializer);

  /** Name Node */
  T visit(Name name);


  // (PackageOrTypeName '.')* TypeName
  // Type Name
  T visit(TypeName typeName);

  // Package Or Type Name
  T visit(PackageOrTypeName packageOrTypeName);

  // Expression Name
  T visit(ExpressionName expressionName);

  // Method Name
  T visit(MethodName methodName);

  // Ambiguous Name
  T visit(AmbiguousName ambiguousName);

  //

}
