package codit.ast.compiler;

import codit.ast.pojos.AstNode;

/**
 * @author Jay Lim
 * @since 8/27/2016
 */
public class CompileApp {

  public static void main(String[] args) {

    Compiler compiler = new Compiler(args[0]);

    AstNode astTree = compiler.compile();

    compiler.writeJsonFileOutput(astTree);
  }
}
