package codit.ast.compiler;

import codit.ast.pojos.AstNode;

/**
 * @author Jay Lim
 * @since 8/27/2016
 */
public class CompileApp {

  public static void main(String[] args) {

    String fileName = "Task";

    Compiler compiler = new Compiler("C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\" + fileName + ".java");

    AstNode astTree = compiler.compile();

    compiler.writeJsonFileOutput(astTree);
  }
}
