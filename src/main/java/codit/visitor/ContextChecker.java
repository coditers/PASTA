package codit.visitor;

import org.antlr.v4.runtime.Token;

import codit.gencode.JavaBaseVisitor;
import codit.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ContextChecker extends JavaBaseVisitor<String> {
  @Override
  public String visitLiteral(JavaParser.LiteralContext ctx) {


    // TODO - Refactoring
    Token t;
    if (ctx.IntegerLiteral() != null) {
      System.out.println("Integer");
      t = ctx.IntegerLiteral().getSymbol();

      if (t.getText().matches("^0[xX][0-9a-fA-F_]*[0-9a-fA-F]L")) {
        System.out.println("LONG && HEX");
      } else if (t.getText().matches("^0[xX][0-9a-fA-F_]*[0-9a-fA-F]")) {
        System.out.println("INT && HEX");
      } else if (t.getText().matches("^0[bB][01_]*[01]L")) {
        System.out.println("LONG && BIN");
      } else if (t.getText().matches("^0[bB][01_]*[01]")) {
        System.out.println("INT && BIN");
      } else if (t.getText().matches("^0[0-7_]*[0-7]L")) {
        System.out.println("LONG && OCT");
      } else if (t.getText().matches("^0[0-7_]*[0-7]")) {
        System.out.println("INT && OCT");
      } else if (t.getText().matches(".+L")) {
        System.out.println("LONG && DEC");
      } else {
        System.out.println("INT && DEC");
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
    if( t != null ) {
      System.out.println("getToken : " + t.getText());
    }


    return super.visitLiteral(ctx);
  }

}
