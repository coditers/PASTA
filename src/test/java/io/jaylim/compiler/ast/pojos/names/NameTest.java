package io.jaylim.compiler.ast.pojos.names;

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

import io.jaylim.compiler.ast.builder.AstBuilder;
import io.jaylim.compiler.ast.compiler.SubCompiler;
import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
@RunWith(Parameterized.class)
public class NameTest {

  private static final Range RANGE = new Range(0, 1, 0, 2);

  private static final int
      TYPE_NAME       = 0,    PACKAGE_OR_TYPE_NAME = 1,
      EXPRESSION_NAME = 2,    AMBIGUOUS_NAME       = 3,
      METHOD_NAME     = 4;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            TYPE_NAME,
            "com.estsoft.pojos.AstNode;",
            new TypeName (RANGE, null, "AstNode",
                new PackageOrTypeName (RANGE, null, "pojos",
                    new PackageOrTypeName (RANGE, null, "estsoft",
                        new PackageOrTypeName(RANGE, null, "com", null))))
        },

        {
            PACKAGE_OR_TYPE_NAME,
            "com.estsoft.pojos",
            new PackageOrTypeName (RANGE, null, "pojos",
                new PackageOrTypeName (RANGE, null, "estsoft",
                    new PackageOrTypeName(RANGE, null, "com", null)))
        },

        {
            EXPRESSION_NAME,
            "modifiers.ModifierSet.STATIC;",
            new ExpressionName (RANGE, null, "STATIC",
                new AmbiguousName (RANGE, null, "ModifierSet",
                    new AmbiguousName (RANGE, null, "modifiers", null)))
        },

        {
            AMBIGUOUS_NAME,
            "modifiers.ModifierSet",
            new AmbiguousName (RANGE, null, "ModifierSet",
                new AmbiguousName(RANGE, null, "modifiers", null))
        },

        {
            METHOD_NAME,
            "someMethod",
            new MethodName(RANGE, null, "someMethod")
        }
    });
  }


  private final int type;
  private final String stringToCompile;
  private final Name targetName;

  public NameTest(int type, String stringToCompile, Name targetName) {
    this.type = type;
    this.stringToCompile = stringToCompile;
    this.targetName = targetName;
  }

  @Test
  public void testName() {
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
      expectedString = mapper.writeValueAsString(targetName);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    System.out.println("Expected : \n" + expectedString + "\n");

    assertThat( astTree, is( equalTo( targetName ) ) );
  }

  private AstNode contextDispatcher(int classifier, JavaParser parser) {

    switch(classifier) {
      case TYPE_NAME :
        return new AstBuilder().visitTypeName(parser.typeName());
      case PACKAGE_OR_TYPE_NAME :
        return new AstBuilder().visitPackageOrTypeName(parser.packageOrTypeName());
      case EXPRESSION_NAME :
        return new AstBuilder().visitExpressionName(parser.expressionName());
      case AMBIGUOUS_NAME :
        return new AstBuilder().visitAmbiguousName(parser.ambiguousName());
      case METHOD_NAME :
        return new AstBuilder().visitMethodName(parser.methodName());
      default :
        System.err.println("ERROR : contextDispatcher");
        return null;
    }
  }
}
