package codit.ast.pojos.literals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.antlr.v4.runtime.ParserRuleContext;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import codit.ast.builder.AstBuilder;
import codit.ast.compiler.SubCompiler;
import codit.ast.pojos.AstNode;
import codit.ast.pojos.Range;
import codit.ast.pojos.expressions.primaries.PrimaryNoNewArray;
import codit.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Ignore
@RunWith(Parameterized.class)
public class PrimaryNoNewArrayTest {

  private static final Range RANGE = new Range(0, 1, 0, 2);

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {},
        {},
        {}
    });
  }

  private final String stringToCompile;
  private final PrimaryNoNewArray targetNode;

  public PrimaryNoNewArrayTest(String stringToCompile, PrimaryNoNewArray targetNode) {
    this.stringToCompile = stringToCompile;
    this.targetNode = targetNode;
  }

  @Ignore
  @Test
  public void testLiteral() {
    SubCompiler subCompiler = new SubCompiler();
    JavaParser parser = subCompiler.getParser(stringToCompile);

    ParserRuleContext ruleContext = parser.primaryNoNewArray();

    AstNode astTree = new AstBuilder().visitPrimaryNoNewArray((JavaParser.PrimaryNoNewArrayContext) ruleContext);

    // JSON serialization
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    String testString = null;

    try {
      testString = mapper.writeValueAsString(astTree);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    System.out.println("AST Tree : \n" + testString + "\n");

    String expectedString = null;

    try {
      expectedString = mapper.writeValueAsString(targetNode);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    System.out.println("Expected : \n" + expectedString + "\n");

    assertThat( astTree, is( equalTo( targetNode ) ) );

  }


}

