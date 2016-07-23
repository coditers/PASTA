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
public class IntegerLiteralTest {
  // Logger
  private static final Logger logger = LoggerFactory.getLogger(LiteralIntegerTest.class);

  // Test Variables
  private final boolean testValid;
  private final String testValue;
  private final int expectedValue;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        /* valid, rawString, expectedValue */

        /* Decimal Integer Literal ( -2,147,483,648 ~ 2,147,483,647 ) */
        {true ,  "0" ,  0 }, // ZERO
        {true ,  "1" ,  1 }, // PLUSONE
        {true , "-1" , -1 }, // MINUS ONE

        {true ,   "1263_3232" ,    12633232 }, // under bar 1
        {true ,   "2_2_6_3_5" ,       22635 }, // under bar 2

        {true ,  "2147483647" ,  2147483647 }, // MAX
        {true , "-2147483648" , -2147483648 }, // MIN TODO - how to deal with '-' character

        /* Error case */
        {false,   "213212abf" , 0}, // Unpredictable character TODO - how is the unpredictable character dealt with
        {false,  "2147483648" , 0}, // Exceed MAX TODO - how to detect exceeded value
        {false, "-2147483649" , 0}, // Exceed MIN TODO - how to deal with exceeded value and '-' character


        /* Hexadecimal Integer Literal ( 0 ~ 0xFFFFFFFF ) */
        {true ,  "0x0_______0"  , 0x0_______0 },  // ZERO
        {true ,  "0x0_______1"  , 0x0_______1 },  // PLUS ONE
        {true ,  "0xFFFF_FFFF"  , 0xFFFF_FFFF },  // MINUS ONE

        {true ,  "0x0_B_fF1a3"  , 0x0_B_fF1a3 },  // under bar 1
        {true ,  "0x2226_2335"  , 0x2226_2335 },  // under bar 2

        {true ,  "0x7FFF_FFFF"  , 0x7FFF_FFFF },  // MAX
        {true ,  "0x8000_0000"  , 0x8000_0000 },  // MIN

        /* Out of bound */
        {false,  "0x__1GFA_0000" , 0}, // Unexpected char TODO - how is the unpredictable character dealt with
        {false,  "0x1_0000_0000" , 0}, // Exceed MAX TODO - how to deal with exceeded value


        /* Octal Integer Literal ( 0 ~ 0_377_7777_7777 ) */
        {true ,  "0_000_0000_0000", 0_000_0000_0000 }, // ZERO
        {true ,               "00",              00 }, // ANOTHER ZERO
        {true ,  "0_000_0000_0001", 0_000_0000_0001 }, // PLUS ONE
        {true ,  "0_377_7777_7777", 0_377_7777_7777 }, // MINUS ONE

        {true ,  "0_000_0000_0263", 0_000_0000_0263 }, // under bar 1
        {true ,  "0_2_63_3_2__211", 0_2_63_3_2__211 }, // under bar 2

        {true ,  "0_177_7777_7777", 0_177_7777_7777 }, // MAX
        {true ,  "0_200_0000_0000", 0_200_0000_0000 }, // MIN

        /* Out of bound */
        {false,  "0_000_0080_0263", 0}, // Unexpected char TODO - how is the unpredictable character dealt with
        {false,  "0_400_0000_0000", 0}, // Exceed MAX TODO - how to deal with exceeded value


        /* Binary Integer Literal ( 0 ~0b1111_1111_1111_1111_1111_1111_1111_1111 ) */
        {true , "0_0", 0b0}, // ZERO
        {true , "0_1", 0b1}, // PLUS ONE
        {true ,
            "0b1111_1111_1111_1111_1111_1111_1111_1111" ,
            0b1111_1111_1111_1111_1111_1111_1111_1111}, // MINUS ONE

        {true ,
            "0b0001_0011_1100_1101_0010_0001_0101_1111" ,
            0b0001_0011_1100_1101_0010_0001_0101_1111},
        {true ,
            "0b1__1___11_11___11_1___1_____1__1_1_1111" ,
            0b1__1___11_11___11_1___1_____1__1_1_1111},

        {true ,
            "0b0111_1111_1111_1111_1111_1111_1111_1111" ,
            0b0111_1111_1111_1111_1111_1111_1111_1111}, // MAX
        {true ,
            "0b1000_0000_0000_0000_0000_0000_0000_0000" ,
            0b1000_0000_0000_0000_0000_0000_0000_0000}, // MIN

        /* Out of bound */
        {false ,   "0b___1___11_11___11_1___1_____1__1_1_1111" , 0}, // Unexpected char TODO - how is the unpredictable character dealt with
        {false , "0b1_0000_0000_0000_0000_0000_0000_0000_0000" , 0}, // Exceed MAX TODO - how to deal with exceeded value

    });
  }


  // Constructors
  public IntegerLiteralTest(boolean testValid,
                            String testValue,
                            int expectedValue) {
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
