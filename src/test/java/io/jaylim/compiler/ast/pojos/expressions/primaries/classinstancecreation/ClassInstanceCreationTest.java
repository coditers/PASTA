package io.jaylim.compiler.ast.pojos.expressions.primaries.classinstancecreation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import io.jaylim.compiler.ast.builder.AstBuilder;
import io.jaylim.compiler.ast.compiler.SubCompiler;
import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.gencode.JavaParser;

/**
 * TODO - Compose test case
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Ignore
@RunWith(Parameterized.class)
public class ClassInstanceCreationTest {

  private static final Range RANGE = new Range(0, 1, 0, 2);


  private static final int
      DEFAULT       = 0,
      LF_PRIMARY    = 1,
      LFNO_PRIMARY  = 2;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        /* Type, String, TargetPojo */
        {DEFAULT, "", },
        {},
        {},
        {}
    });
  }

  private final int type;
  private final String stringToCompile;
  private final ClassInstanceCreationExpression targetPojo;

  public ClassInstanceCreationTest(final int type, final String stringToCompile,
                                   final ClassInstanceCreationExpression targetPojo) {
    this.type = type;
    this.stringToCompile = stringToCompile;
    this.targetPojo = targetPojo;
  }

  @Test
  public void testClassInstanceCreationExpression() {
    SubCompiler subCompiler = new SubCompiler();
    JavaParser parser = subCompiler.getParser(stringToCompile);

    AstNode astTree = contextDispatcher(type, parser);

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

  private AstNode contextDispatcher(int classifier, JavaParser parser) {

    switch(classifier) {
      case DEFAULT :
        return new AstBuilder().visitClassInstanceCreationExpression(parser.classInstanceCreationExpression());
      case LF_PRIMARY :
        return new AstBuilder().visitClassInstanceCreationExpression_lf_primary(parser.classInstanceCreationExpression_lf_primary());
      case LFNO_PRIMARY :
        return new AstBuilder().visitClassInstanceCreationExpression_lfno_primary(parser.classInstanceCreationExpression_lfno_primary());
      default :
        System.err.println("ERROR : contextDispatcher");
        return null;
    }
  }

}
