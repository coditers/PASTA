import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.File;
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

    String fileName = "testcode2";
g
    BufferedReader br = null;

    StringBuilder stringBuilder = new StringBuilder("");

    try {

      String sCurrentLine;

      br = new BufferedReader(new FileReader("C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\" + fileName + ".txt"));

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

    // JSON serialization
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    try {
      // Convert object to JSON string and save into a file directly
      mapper.writeValue(new File("C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\" + fileName + ".out.json"), astTree);

      // Convert object to JSON string and pretty print
      String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(astTree);
      System.out.println(jsonInString);

    } catch (IOException e) {
      e.printStackTrace();
    }

  }
}
