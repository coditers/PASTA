package io.jaylim.compiler.ast.pojos.literals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.antlr.v4.runtime.ParserRuleContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import io.jaylim.compiler.ast.pojos.AstNode;
import io.jaylim.compiler.ast.pojos.Range;
import io.jaylim.compiler.ast.builder.AstBuilder;
import io.jaylim.compiler.ast.compiler.SubCompiler;
import io.jaylim.compiler.ast.pojos.literals.doubles.DecimalDoubleLiteral;
import io.jaylim.compiler.ast.pojos.literals.doubles.HexDoubleLiteral;
import io.jaylim.compiler.ast.pojos.literals.floats.DecimalFloatLiteral;
import io.jaylim.compiler.ast.pojos.literals.floats.HexFloatLiteral;
import io.jaylim.compiler.ast.pojos.literals.integers.BinaryIntegerLiteral;
import io.jaylim.compiler.ast.pojos.literals.integers.DecimalIntegerLiteral;
import io.jaylim.compiler.ast.pojos.literals.integers.HexIntegerLiteral;
import io.jaylim.compiler.ast.pojos.literals.integers.OctalIntegerLiteral;
import io.jaylim.compiler.ast.pojos.literals.longs.BinaryLongLiteral;
import io.jaylim.compiler.ast.pojos.literals.longs.DecimalLongLiteral;
import io.jaylim.compiler.ast.pojos.literals.longs.HexLongLiteral;
import io.jaylim.compiler.ast.pojos.literals.longs.OctalLongLiteral;
import io.jaylim.compiler.gencode.JavaParser;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */

@RunWith(Parameterized.class)
public class LiteralTest {

  private static final Range RANGE = new Range(0,1,0,2);

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{

        // String
        { "\"String Literal\"", new StringLiteral(RANGE, null, "\"String Literal\"") } ,

        // Character
        { "\'a\'"             , new CharacterLiteral(RANGE, null, "\'a\'")           } ,

        // Integer
        { "1234"    , new DecimalIntegerLiteral(RANGE, null, "1234")    } ,
        { "0x1234"  , new     HexIntegerLiteral(RANGE, null, "0x1234")  } ,
        { "0_1234"  , new   OctalIntegerLiteral(RANGE, null, "0_1234")  } ,
        { "0b1010"  , new  BinaryIntegerLiteral(RANGE, null, "0b1010")  } ,

        // Long
        { "1234L"   , new    DecimalLongLiteral(RANGE, null, "1234L")   } ,
        { "0x1234L" , new        HexLongLiteral(RANGE, null, "0x1234L") } ,
        { "0_1234L" , new      OctalLongLiteral(RANGE, null, "0_1234L") } ,
        { "0b1010L" , new     BinaryLongLiteral(RANGE, null, "0b1010L") } ,

        // Float
        { "0x32.12p-110f" , new     HexFloatLiteral(RANGE, null, "0x32.12p-110f")},
        { "32.12e-21132f" , new DecimalFloatLiteral(RANGE, null, "32.12e-21132f")},

        // Double
        { "0x32.12p-110" , new     HexDoubleLiteral(RANGE, null, "0x32.12p-110")},
        { "32.12e-21132" , new DecimalDoubleLiteral(RANGE, null, "32.12e-21132")},

        // Boolean
        { "true"  , new BooleanLiteral(RANGE, null, "true" )},
        { "false" , new BooleanLiteral(RANGE, null, "false")},

        // Null
        { "null" , new NullLiteral(RANGE, null, "null")}
    });
  }

  private final String stringToCompile;
  private final Literal targetLiteral;

  public LiteralTest(String stringToCompile, Literal targetLiteral) {
    this.stringToCompile = stringToCompile;
    this.targetLiteral = targetLiteral;
  }

  @Test
  public void testLiteral() {
    SubCompiler subCompiler = new SubCompiler();
    JavaParser parser = subCompiler.getParser(stringToCompile);

    ParserRuleContext ruleContext = parser.literal();

    AstNode astTree = new AstBuilder().visitLiteral((JavaParser.LiteralContext) ruleContext);

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
      expectedString = mapper.writeValueAsString(targetLiteral);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    System.out.println("Expected : \n" + expectedString + "\n");

    assertThat( astTree, is( equalTo( targetLiteral ) ) );

  }
}
