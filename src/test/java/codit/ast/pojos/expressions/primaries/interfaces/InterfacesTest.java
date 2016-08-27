package codit.ast.pojos.expressions.primaries.interfaces;

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
public class InterfacesTest {

  private static final Range RANGE = new Range(0, 1, 0, 2);

  private static final int
      DEFAULT_ARRAY_DEFAULT_PRIMARY = 0,
      DEFAULT_ARRAY_LF_PRIMARY      = 1,
      DEFAULT_ARRAY_LFNO_PRIMARY    = 2,

      LF_ARRAY_DEFAULT_PRIMARY = 3,
      LF_ARRAY_LF_PRIMARY      = 4,
      LF_ARRAY_LFNO_PRIMARY    = 5,

      LFNO_ARRAY_DEFALUT_PRIMARY = 6,
      LFNO_ARRAY_LF_PRIMARY      = 7,
      LFNO_ARRAY_LFNO_PRIMARY    = 8;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] { // TODO - Compose Test Case
        /* int typeClassifer, String stringToCompile, ArrayPrimary targetPojo */
        {},
        {},
        {},
        {}
    });
  }

  private final int type;
  private final String stringToCompile;
  private final ArrayPrimary targetPojo;

  public InterfacesTest(final int type, final String stringToCompile,
                                   final ArrayPrimary targetPojo) {
    this.type = type;
    this.stringToCompile = stringToCompile;
    this.targetPojo = targetPojo;
  }


  @Test
  public void testInterfaces() {
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
      case DEFAULT_ARRAY_DEFAULT_PRIMARY :
        return new AstBuilder().visitPrimaryNoNewArray(parser.primaryNoNewArray());
      case DEFAULT_ARRAY_LF_PRIMARY :
        return new AstBuilder().visitPrimaryNoNewArray_lf_primary(parser.primaryNoNewArray_lf_primary());
      case DEFAULT_ARRAY_LFNO_PRIMARY :
        return new AstBuilder().visitPrimaryNoNewArray_lfno_primary(parser.primaryNoNewArray_lfno_primary());
      case LF_ARRAY_DEFAULT_PRIMARY :
        return new AstBuilder().visitPrimaryNoNewArray_lf_arrayAccess(parser.primaryNoNewArray_lf_arrayAccess());
      case LF_ARRAY_LF_PRIMARY :
        return new AstBuilder().visitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(parser.primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary());
      case LF_ARRAY_LFNO_PRIMARY :
        return new AstBuilder().visitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(parser.primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary());
      case LFNO_ARRAY_DEFALUT_PRIMARY :
        return new AstBuilder().visitPrimaryNoNewArray_lfno_arrayAccess(parser.primaryNoNewArray_lfno_arrayAccess());
      case LFNO_ARRAY_LF_PRIMARY :
        return new AstBuilder().visitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(parser.primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary());
      case LFNO_ARRAY_LFNO_PRIMARY :
        return new AstBuilder().visitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(parser.primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary());
      default :
        System.err.println("ERROR : contextDispatcher");
        return null;
    }
  }
}
