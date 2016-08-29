package codit.ast.compiler;

import codit.ast.pojos.AstNode;

/**
 * @author Jay Lim
 * @since 8/27/2016
 */
public class CompileApp {

  public static void main(String[] args) {

    Compiler compiler;
    if (args[1] == null) {
      compiler = new Compiler(args[0], args[1]);
    } else {
      compiler = new Compiler(args[0], args[1]);
    }

    AstNode astTree = compiler.compile();

    compiler.writeJsonFileOutput(astTree);
  }
}
