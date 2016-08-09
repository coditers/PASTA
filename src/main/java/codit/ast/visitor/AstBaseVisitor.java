package codit.ast.visitor;

import codit.ast.pojos.AstNode;
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
public class AstBaseVisitor<T> extends AbstractNodeVisitor<T> implements AstVisitor<T> {

  @Override
  public T visitSomething(AstNode astNode) {
    return visitChildren(astNode);
  }


  @Override
  public T visit(Literal literal) {
    return visitChildren(literal);
  }

  @Override
  public T visit(FloatLiteral floatLiteral) {
    return visitChildren(floatLiteral);
  }

  @Override
  public T visit(DecimalFloatLiteral decimalFloatLiteral) {
    return visitChildren(decimalFloatLiteral);
  }

  @Override
  public T visit(HexFloatLiteral hexFloatLiteral) {
    return visitChildren(hexFloatLiteral);
  }

  @Override
  public T visit(IntegerLiteral integerLiteral) {
    return visitChildren(integerLiteral);
  }

  @Override
  public T visit(BinaryIntegerLiteral binaryIntegerLiteral) {
    return visitChildren(binaryIntegerLiteral);
  }

  @Override
  public T visit(OctalIntegerLiteral octalIntegerLiteral) {
    return visitChildren(octalIntegerLiteral);
  }

  @Override
  public T visit(DecimalIntegerLiteral decimalIntegerLiteral) {
    return visitChildren(decimalIntegerLiteral);
  }

  @Override
  public T visit(HexIntegerLiteral hexIntegerLiteral) {
    return visitChildren(hexIntegerLiteral);
  }

  @Override
  public T visit(CharacterLiteral characterLiteral) {
    return visitChildren(characterLiteral);
  }

  @Override
  public T visit(StringLiteral stringLiteral) {
    return visitChildren(stringLiteral);
  }

  @Override
  public T visit(BooleanLiteral booleanLiteral) {
    return visitChildren(booleanLiteral);
  }

  @Override
  public T visit(NullLiteral nullLiteral) {
    return visitChildren(nullLiteral);
  }

  @Override
  public T visit(VariableDeclarator variableDeclarator) {
    return visitChildren(variableDeclarator);
  }

  @Override
  public T visit(VariableDeclaratorId variableDeclaratorId) {
    return visitChildren(variableDeclaratorId);
  }

  @Override
  public T visit(VariableInitializer variableInitializer) {
    return visitChildren(variableInitializer);
  }

  @Override
  public T visit(Name name) {
    return visitChildren(name);
  }

  @Override
  public T visit(TypeName typeName) {
    return visitChildren(typeName);
  }

  @Override
  public T visit(PackageOrTypeName packageOrTypeName) {
    return visitChildren(packageOrTypeName);
  }

  @Override
  public T visit(ExpressionName expressionName) {
    return visitChildren(expressionName);
  }

  @Override
  public T visit(MethodName methodName) {
    return visitChildren(methodName);
  }

  @Override
  public T visit(AmbiguousName ambiguousName) {
    return visitChildren(ambiguousName);
  }
}
