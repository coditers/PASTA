package codit.ast.pojos.expressions.primaries.methodinvocation;

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

import codit.ast.builder.AstBuilder;
import codit.ast.compiler.SubCompiler;
import codit.ast.pojos.AstNode;
import codit.ast.pojos.Range;
import codit.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@Ignore
public class MethodInvocationTest {

  private static final Range RANGE = new Range(0, 1, 0, 2);


  private static final int
      DEFAULT       = 0x0010,
      LF_PRIMARY    = 0x0020,
      LFNO_PRIMARY  = 0x0040;


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
  private final MethodInvocation targetPojo;

  public MethodInvocationTest(final int type, final String stringToCompile,
  final MethodInvocation targetPojo) {
    this.type = type;
    this.stringToCompile = stringToCompile;
    this.targetPojo = targetPojo;
  }

  @Test
  public void testMethodInvocation() {
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
        return new AstBuilder().visitMethodInvocation(parser.methodInvocation());
      case LF_PRIMARY :
        return new AstBuilder().visitMethodInvocation_lf_primary(parser.methodInvocation_lf_primary());
      case LFNO_PRIMARY :
        return new AstBuilder().visitMethodInvocation_lfno_primary(parser.methodInvocation_lfno_primary());
      default :
        System.err.println("ERROR : contextDispatcher");
        return null;
    }
  }
}
