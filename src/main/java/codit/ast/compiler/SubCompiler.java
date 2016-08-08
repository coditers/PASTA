package codit.ast.compiler;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import codit.gencode.JavaLexer;
import codit.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class SubCompiler {

  public JavaParser getParser(String inputString) {

    ANTLRInputStream input = new ANTLRInputStream(inputString);
    JavaLexer lexer = new JavaLexer(input);
    TokenStream tokens = new CommonTokenStream(lexer);
    JavaParser parser = new JavaParser(tokens);

    return parser;
  }


}
