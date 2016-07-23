package codit.ast.pojos.literals;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

import codit.ast.AstNode;
import codit.ast.builder.AstBuilder;
import codit.ast.pojos.literals.integers.IntegerLiteral;
import codit.gencode.JavaLexer;
import codit.gencode.JavaParser;
import codit.strategy.ErrorInspectorStrategy;
import codit.visitor.ExceptionInspector;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */

@RunWith(Parameterized.class)
public class LongLiteralTest {
  // Logger
  private static final Logger logger = LoggerFactory.getLogger(LiteralIntegerTest.class);

  // Test Variables
  private final boolean testValid;
  private final String testValue;
  private final long expectedValue;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        /* valid, rawString, expectedValue */

        /* Decimal Long Literal ( -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 ) */
        {true ,                    "0L" ,                    0L }, // ZERO
        {true ,                    "1L" ,                    1L }, // PLUSONE
        {true ,                   "-1L" ,                   -1L }, // MINUS ONE

        {true ,            "1263_3232L" ,             12633232L }, // under bar 1
        {true ,            "2_2_6_3_5L" ,                22635L }, // under bar 2

        {true ,  "9223372036854775807L" ,  9223372036854775807L }, // MAX
        {true , "-9223372036854775808L" , -9223372036854775808L }, // MIN

        /* Out of bound */
        {false ,   "12412412412222awf2L" , 0L }, // Unpredictable character
        {false ,  "9223372036854775808L" , 0L }, // Exceed MAX
        {false , "-9223372036854775809L" , 0L }, // Exceed MIN


        /* Hexadecimal Long Literal ( 0 ~ 0xFFFFFFFFFFFFFFFFL ) */
        {true ,  "0x0000_0000_0000_0000L"  , 0x0000_0000_0000_0000L },  // ZERO
        {true ,  "0x0000_0000_0000_0001L"  , 0x0000_0000_0000_0001L },  // PLUS ONE
        {true ,  "0xFFFF_FFFF_FFFF_FFFFL"  , 0xFFFF_FFFF_FFFF_FFFFL },  // MINUS ONE

        {true ,  "0x0_B_fF1a3L"  , 0x0_B_fF1a3L },  // under bar 1
        {true ,  "0x2226_2335L"  , 0x2226_2335L },  // under bar 2

        {true ,  "0x7FFF_FFFF_FFFF_FFFFL"  , 0x7FFF_FFFF_FFFF_FFFFL },  // MAX
        {true ,  "0x8000_0000_0000_0000L"  , 0x8000_0000_0000_0000L },  // MIN

        /* Out of bound */
        {false,  "0x____________1GFA_0000L" , 0L}, // Unexpected char
        {false,  "0x1_0000_0000_0000_0000L" , 0L}, // Exceed MAX


        /* Octal Long Literal ( 0 ~ 0_17_7777_7777_7777_7777_7777L ) */
        {true ,  "0_00_0000_0000_0000_0000_0000L", 0_00_0000_0000_0000_0000_0000L }, // ZERO
        {true ,                             "00L",                            00L }, // ANOTHER ZERO
        {true ,  "0_00_0000_0000_0000_0000_0001L", 0_00_0000_0000_0000_0000_0001L }, // PLUS ONE
        {true ,  "0_17_7777_7777_7777_7777_7777L", 0_17_7777_7777_7777_7777_7777L }, // MINUS ONE

        {true ,  "0_000_0000_0263L", 0_000_0000_0263L },
        {true ,  "0_2_63_3_2__211L", 0_2_63_3_2__211L },

        {true ,  "0_07_7777_7777_7777_7777_7777L", 0_07_7777_7777_7777_7777_7777L }, // MAX
        {true ,  "0_10_0000_0000_0000_0000_0000L", 0_10_0000_0000_0000_0000_0000L }, // MIN

        /* Out of bound */
        {false,  "0_20_0000_0080_0000_0000_0000L" , 0L}, // Unexpected char
        {false,  "0_20_0000_0000_0000_0000_0000L" , 0L}, // Exceed MAX


        /* Binary Long Literal ( 0 ~0b1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111 ) */
        {true , "0_0L", 0b0L}, // ZERO
        {true , "0_1L", 0b1L}, // PLUS ONE
        {true ,
            "0b1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L" ,
            0b1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L }, // MINUS ONE

        {true ,
            "0b0001_0011_1100_1101_0010_0001_0101_1111L" ,
            0b0001_0011_1100_1101_0010_0001_0101_1111L },
        {true ,
            "0b1__1___11_11___11_1___1_____1__1_1_1111L" ,
            0b1__1___11_11___11_1___1_____1__1_1_1111L},

        {true ,
            "0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L" ,
            0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L }, // MAX
        {true ,
            "0b1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L" ,
            0b1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L }, // MIN

        /* Out of bound */
        {false ,   "0b___1___11_11___11_1___1_____1__1_1_1111L" , 0L }, // Unexpected char
        {false,  "0b1_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L" , 0L }, // Exceed MAX

    });
  }


  // Constructors
  public LongLiteralTest(boolean testValid,
                            String testValue,
                            long expectedValue) {
    // Test valid
    this.testValid = testValid;

    // Test value
    this.testValue = testValue;

    // Expected value
    this.expectedValue = expectedValue;
  }


  @Before
  public void setUp() {
    System.out.println("START=============================================================================================================================");
    logger.info( "[ Test Valid : " + this.testValid + " ] " + this.testValue );
  }

  @org.junit.Test
  public void testIdenticalPojos() {
    JavaParser parser = compiler(testValue);
    ParserRuleContext ruleContext = parser.literal();

    // VISITOR - CONTEXT CHECKER
    AstNode node = new AstBuilder().visitLiteral((JavaParser.LiteralContext) ruleContext);

    IntegerLiteral iLiteral = (IntegerLiteral) node;

    Literal expectedLiteral = new Literal(iLiteral.getRange(), iLiteral.getParent(), testValue) {};

    // VISITOR - EXCEPTION INSPECTOR - Alert Error
    String exception = new ExceptionInspector().visitLiteral((JavaParser.LiteralContext) ruleContext);
    System.out.println( exception );

    logger.info(iLiteral.getRange() + " Return : " + iLiteral.getRawString());
    logger.info(expectedLiteral.getRange() + " Expect : " +  expectedLiteral.getRawString());

    if (this.testValid) {
      assertThat( iLiteral, is( equalTo(expectedLiteral) ) );
      assertThat( exception, is( nullValue() ) );
    } else {
      assertThat(exception, is( notNullValue() ) );
    }
  }

  @Ignore("This method isn't working yet.")
  public void testExceptionOccurs() {

  }

  @Ignore("This method isn't working yet.")
  public void testParsedValue() {
    // It's gonna deal with the semantic issues.
  }

  @After
  public void shutDown() {
//    logger.info( ruleContext.toStringTree((Arrays.asList(JavaParser.ruleNames))) + " : " + ruleContext.toInfoString(parser) + " ::: " + ruleContext.children );
    System.out.println("===============================================================================================================================END");
  }

  private JavaParser compiler(String code) {

    ANTLRInputStream input = new ANTLRInputStream( code );
    JavaLexer lexer = new JavaLexer(input);
    TokenStream tokens = new CommonTokenStream(lexer);

    JavaParser parser = new JavaParser(tokens);

    parser.setBuildParseTree(true);

    // LISTENER - LOGGER
//    parser.addParseListener(new LoggingListener());
    parser.setErrorHandler(new ErrorInspectorStrategy());
    return parser;
  }
}
