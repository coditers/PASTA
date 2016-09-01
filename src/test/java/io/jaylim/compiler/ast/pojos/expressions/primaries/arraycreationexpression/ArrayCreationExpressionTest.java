package io.jaylim.compiler.ast.pojos.expressions.primaries.arraycreationexpression;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import io.jaylim.compiler.ast.builder.AstBuilder;
import io.jaylim.compiler.ast.compiler.SubCompiler;
import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Ignore
public class ArrayCreationExpressionTest {

  private static final Range RANGE = new Range(0, 1, 0, 2);

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        /* String, TargetPojo */
        {"", },
        {},
        {},
        {}
    });
  }

  private final String stringToCompile;
  private final ArrayCreationExpression targetPojo;

  public ArrayCreationExpressionTest(final String stringToCompile,
                                     final ArrayCreationExpression targetPojo) {
    this.stringToCompile = stringToCompile;
    this.targetPojo = targetPojo;
  }

  @Test
  public void testArrayCreationExpression() {
    SubCompiler subCompiler = new SubCompiler();
    JavaParser parser = subCompiler.getParser(stringToCompile);

    AstNode astTree = new AstBuilder().visitArrayCreationExpression(parser.arrayCreationExpression());

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
      expectedString = mapper.writeValueAsString(targetPojo);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    System.out.println("Expected : \n" + expectedString + "\n");

    assertThat( astTree, is( equalTo( targetPojo ) ) );
  }
}
