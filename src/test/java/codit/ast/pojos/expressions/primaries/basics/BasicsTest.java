package codit.ast.pojos.expressions.primaries.basics;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import codit.ast.builder.AstBuilder;
import codit.ast.compiler.SubCompiler;
import codit.ast.pojos.AstNode;
import codit.ast.pojos.Range;
import codit.ast.pojos.literals.integers.HexIntegerLiteral;
import codit.ast.pojos.names.PackageOrTypeName;
import codit.ast.pojos.names.TypeName;
import codit.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@RunWith(Parameterized.class)
public class BasicsTest {


  private static final Range RANGE = new Range(0, 1, 0, 2);

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        /* String, TargetPojo */

        { // literal
            "0x1A3B12",
            new LiteralExpression (RANGE, null,
                new HexIntegerLiteral(RANGE, null, "0x1A3B12"))
        },

        { // typeName ( '[' ']' )* '.' 'class'
            "pojos.Modifiers.TERM[][].class",
            new ReferenceClassLiteralExpression (RANGE, null,
                new TypeName(RANGE, null, "TERM",
                    new PackageOrTypeName(RANGE, null, "Modifiers",
                        new PackageOrTypeName(RANGE, null, "pojos", null))),
                2
            )
        },

        /* TODO - UNANNOTATED_PRIMITIVE_TYPE
        { // unannPrimitiveType ( '[' ']' )* '.' 'class'
            "",
            new PrimitiveClassLiteralExpression
                (
                    RANGE, null,
                    new UnannPrimitiveType
                        (

                        ),
                    2
                )
        },
        */

        { // 'void' '.' 'class'
            "void.class",
            new VoidClassLiteralExpression(RANGE, null)
        },

        { // 'this'
            "this",
            new BasicThisExpression(RANGE, null)
        },

        { // typeName '.' 'this'
            "pojos.Modifiers.TERM.this",
            new ReferenceThisExpression (RANGE, null,
                new TypeName(RANGE, null, "TERM",
                    new PackageOrTypeName(RANGE, null, "Modifiers",
                        new PackageOrTypeName(RANGE, null, "pojos", null))))
        },

        /* TODO - PARENTHESIZED_EXPRESSION
        { // '(' expression ')'
            "()"
        }
        */
    });
  }

  private final String stringToCompile;
  private final BasicExpression targetPojo;

  public BasicsTest(final String stringToCompile, final BasicExpression targetPojo) {
    this.stringToCompile = stringToCompile;
    this.targetPojo = targetPojo;
  }

  @Test
  public void testBasics() {
    SubCompiler subCompiler = new SubCompiler();
    JavaParser parser = subCompiler.getParser(stringToCompile);

    AstNode astTree = new AstBuilder().visitPrimaryNoNewArray_lfno_primary(parser.primaryNoNewArray_lfno_primary());

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
