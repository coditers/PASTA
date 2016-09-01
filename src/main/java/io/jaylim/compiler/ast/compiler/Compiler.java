package io.jaylim.compiler.ast.compiler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import io.jaylim.compiler.ast.builder.AstBuilder;
import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.gencode.JavaLexer;
import io.jaylim.compiler.gencode.JavaParser;

/**
 * @author Jay Lim
 * @since  8/28/2016
 */
public class Compiler {

  private String inputAbsolutePath;
  private String outputAbsolutePath;

  private String code;

  public Compiler(String inputAbsolutePath, String outputAbsolutePath) {
    this.inputAbsolutePath = inputAbsolutePath;

    if (outputAbsolutePath.endsWith("json")) {
      this.outputAbsolutePath = outputAbsolutePath;
    } else {
      this.outputAbsolutePath = outputAbsolutePath + "\\out.json";
    }

    this.code = getTextCode();
  }

  public Compiler(String inputAbsolutePath) {

    this.inputAbsolutePath = inputAbsolutePath;
    this.outputAbsolutePath = inputAbsolutePath.substring(0, inputAbsolutePath.length()-4) + "out.json";

    this.code = getTextCode();
  }

  private String getTextCode() {

    StringBuilder stringBuilder = new StringBuilder("");

    try ( BufferedReader br = new BufferedReader(new FileReader(inputAbsolutePath)) ) {

      String sCurrentLine;

      while ((sCurrentLine = br.readLine()) != null) {
        stringBuilder.append("\r\n");
        stringBuilder.append(sCurrentLine);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }

    return stringBuilder.toString();
  }

  public AstNode compile() {

    ANTLRInputStream input = new ANTLRInputStream(code);
    JavaLexer lexer = new JavaLexer(input);
    TokenStream tokens = new CommonTokenStream(lexer);
    JavaParser parser = new JavaParser(tokens);

    return new AstBuilder().visitCompilationUnit(parser.compilationUnit());
  }

  public void writeJsonFileOutput(AstNode astTree) {
    // JSON serialization
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    try {
      // Convert object to JSON string and save into a file directly
      mapper.writeValue(new File(outputAbsolutePath), astTree);

      // Convert object to JSON string and pretty print
      String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(astTree);
      System.out.println(jsonInString);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
