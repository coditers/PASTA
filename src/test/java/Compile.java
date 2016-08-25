import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import codit.ast.builder.AstBuilder;
import codit.ast.compiler.SubCompiler;
import codit.ast.pojos.AstNode;
import codit.gencode.JavaParser;

/**
 * @author Jay Lim
 * @since  8/23/2016
 */
public class Compile {
  public static void main(String[] args) {

    BufferedReader br = null;

    StringBuilder stringBuilder = new StringBuilder("");

    try {

      String sCurrentLine;

      br = new BufferedReader(new FileReader("C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\testcode.txt"));

      while ((sCurrentLine = br.readLine()) != null) {
        stringBuilder.append("\r\n");
        stringBuilder.append(sCurrentLine);
      }

    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        if (br != null)br.close();
      } catch (IOException ex) {
        ex.printStackTrace();
      }
    }

    String testcode = stringBuilder.toString();


    SubCompiler subCompiler = new SubCompiler();
    JavaParser parser = subCompiler.getParser(testcode);

    AstNode astTree = new AstBuilder().visitCompilationUnit(parser.compilationUnit());


  }
}
