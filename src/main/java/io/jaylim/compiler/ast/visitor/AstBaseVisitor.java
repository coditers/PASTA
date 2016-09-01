package io.jaylim.compiler.ast.visitor;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.literals.BooleanLiteral;
import io.jaylim.compiler.ast.pojos.literals.CharacterLiteral;
import io.jaylim.compiler.ast.pojos.literals.Literal;
import io.jaylim.compiler.ast.pojos.literals.NullLiteral;
import io.jaylim.compiler.ast.pojos.literals.StringLiteral;
import io.jaylim.compiler.ast.pojos.literals.floats.DecimalFloatLiteral;
import io.jaylim.compiler.ast.pojos.literals.floats.FloatLiteral;
import io.jaylim.compiler.ast.pojos.literals.floats.HexFloatLiteral;
import io.jaylim.compiler.ast.pojos.literals.integers.BinaryIntegerLiteral;
import io.jaylim.compiler.ast.pojos.literals.integers.DecimalIntegerLiteral;
import io.jaylim.compiler.ast.pojos.literals.integers.HexIntegerLiteral;
import io.jaylim.compiler.ast.pojos.literals.integers.IntegerLiteral;
import io.jaylim.compiler.ast.pojos.literals.integers.OctalIntegerLiteral;
import io.jaylim.compiler.ast.pojos.names.AmbiguousName;
import io.jaylim.compiler.ast.pojos.names.ExpressionName;
import io.jaylim.compiler.ast.pojos.names.MethodName;
import io.jaylim.compiler.ast.pojos.names.Name;
import io.jaylim.compiler.ast.pojos.names.PackageOrTypeName;
import io.jaylim.compiler.ast.pojos.names.TypeName;
import io.jaylim.compiler.ast.pojos.variables.VariableDeclarator;
import io.jaylim.compiler.ast.pojos.variables.VariableDeclaratorId;
import io.jaylim.compiler.ast.pojos.variables.VariableInitializer;

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
