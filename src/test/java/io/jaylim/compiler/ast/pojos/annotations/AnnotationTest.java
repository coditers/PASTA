package io.jaylim.compiler.ast.pojos.annotations;

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
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Ignore
@RunWith(Parameterized.class)
public class AnnotationTest {

  private static final Range RANGE = new Range(0, 0, 0 ,0);


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            "@NormalAnnotation(condExpr=((a==b)?a:b), " +
                              "arrInit={\"first\", \"second\", \"third\"}, " +
                              "ann=@Marker)",
            null
//            new NormalAnnotation
//                (
//                    RANGE, null,
//                    new TypeName(RANGE, null, "NormarAnnotation", null),
//                    new ArrayList<ElementValuePair>()
//                    {
//                      new ElementValuePair
//                        (
//                            RANGE, null, "condExpr",
//                            new ParenthesizedExpression
//                              (RANGE, null,
//                                new TernaryConditionalExpression
//                                  (
//                                    RANGE, null,
//                                    new EqualEqualityExpression(RANGE, null, "a", "b")
//                                  )
//                              )
//                        ),
//                      new ElementValuePair(),
//                      new ElementValuePair()
//                    }
//                )
        },
        {
            "@MarkerAnnotation",
            null
        },
        {
            "@SingleElementAnnotation(val=\"str\")",
            null
        },
    });
  }

  private final String stringToCompile;
  private final Annotation targetPojo;

  public AnnotationTest(final String stringToCompile, final Annotation targetPojo) {
    this.stringToCompile = stringToCompile;
    this.targetPojo = targetPojo;
  }

  @Test
  public void testAnnotation() {
    SubCompiler subCompiler = new SubCompiler();
    JavaParser parser = subCompiler.getParser(stringToCompile);

    AstNode astTree = new AstBuilder().visitAnnotation(parser.annotation());

    // JSON serialization
    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);
    mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

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
