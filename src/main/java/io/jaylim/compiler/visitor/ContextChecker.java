package io.jaylim.compiler.visitor;

import org.antlr.v4.runtime.Token;

import java.util.Arrays;

import io.jaylim.compiler.gencode.JavaBaseVisitor;
import io.jaylim.compiler.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ContextChecker extends JavaBaseVisitor<String[]> {
  @Override
  public String[] visitLiteral(JavaParser.LiteralContext ctx) {

    System.out.println(ctx.toString(Arrays.asList(JavaParser.ruleNames)));

    // TODO - Refactoring
    Token t;
    String[] resultSet; // Integer - 3, Boolean -

    if (ctx.IntegerLiteral() != null) { resultSet = new String[3];

      // get raw text
      t = ctx.IntegerLiteral().getSymbol();
      String iLiteral = t.getText();

      // put in result Set
      resultSet[0] = iLiteral;

      if ( iLiteral.startsWith("0x") || iLiteral.startsWith("0X") ) {
        // Hex Integer Literals
        resultSet[1] = "HEX";

      } else if ( iLiteral.startsWith("0b") || iLiteral.startsWith("0B") ) {
        // Binary Integer Literals
        resultSet[1] = "BIN";

      } else if ( iLiteral.startsWith("0") && !iLiteral.equals("0") ) {
        // Oct Integer Literals
        resultSet[1] = "OCT";

      } else {
        // Dec Integer Literals
        resultSet[1] = "DEC";

      }

    } else if (ctx.BooleanLiteral() != null) {
      System.out.println("Boolean");
      t = ctx.BooleanLiteral().getSymbol();
    } else if (ctx.StringLiteral() != null) {
      System.out.println("String");
      t = ctx.StringLiteral().getSymbol();
    } else if (ctx.CharacterLiteral() != null) {
      System.out.println("Char");
      t = ctx.CharacterLiteral().getSymbol();
    } else if (ctx.FloatingPointLiteral() != null) {
      System.out.println("FloatPoint");
      t = ctx.FloatingPointLiteral().getSymbol();
    } else if (ctx.NullLiteral() != null) {
      System.out.println("Null");
      t = ctx.NullLiteral().getSymbol();
    } else {
      t = null;
    }


    return super.visitLiteral(ctx);
  }

}
