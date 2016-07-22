package codit.ast.pojos.literals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.junit.After;
import org.junit.Before;
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
public class LiteralIntegerTest {

  // Logger
  private static final Logger logger = LoggerFactory.getLogger(LiteralIntegerTest.class);

  // Test Variables
  private final boolean testValid;
  private final String testValue;
  private final String expectedValue;
  private final boolean isLong;

  // Constructors
  public LiteralIntegerTest(boolean testValid,
                            String testValue,
                            String expectedValue) {
    // Test valid
    this.testValid = testValid;

    // Test value
    this.testValue = testValue;

    // Expected value
    this.expectedValue = expectedValue;

    // is Long value?
    this.isLong = isLong;
  }

  // Parameterized values
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        /* valid, rawString, expectedValue */

        /*Decimal Integer Literal ( -2147483648 ~ 2147483647 ) */
        {true ,  "0"          ,           0 }, // ZERO
        {true ,  "1"          ,           1 }, // PLUSONE
        {true , "-1"          ,          -1 }, // MINUS ONE
        {true ,  "13"         ,          13 },
        {true ,  "263"        ,         263 },
        {true ,  "1263_3232"  ,    12633232 },
        {true ,  "2633_2211"  ,    26332211 },
        {true ,  "2_2_6_3_5"  ,       22635 },
        {true ,  "2147483647" ,  2147483647 }, // MAX
        {true , "-2147483648" , -2147483648 }, // MIN

        /* Out of bound */
        {false,  "2147483648" , 0}, // Exceed MAX
        {false, "-2147483649" , 0}, // Exceed MIN

        /*Hexadecimal Integer Literal ( 0 ~ 0XFFFF_FFFF ) */
        {true ,  "0x0_______0"  , 0x0_______0 }, // ZERO
        {true ,  "0x0_______1"  , 0x0_______1 }, // PLUS ONE
        {true ,  "0xFFFF_FFFF"  , 0xFFFF_FFFF }, // MINUS ONE
        {true ,  "0x0______13"  , 0x0______13 }, //
        {true ,  "0x0_____263"  , 0x0_____263 }, //
        {true ,  "0x1263_3232"  , 0x1263_3232 }, //
        {true ,  "0x2633_2211"  , 0x2633_2211 }, //
        {true ,  "0x2226_2335"  , 0x2226_2335 }, //
        {true ,  "0x7FFF_FFFF"  , 0x7FFF_FFFF }, // MAX
        {true ,  "0x8000_0000"  , 0x8000_0000 }, // MIN

        /* Out of bound */
        {false,  "0x1_0000_0000" , 0}, // Exceed MAX

        /* Octal Integer Literal ( 0 ~ 0_377_7777_7777 ) */
        {true ,  "0_____________0", 0_____________0 }, // ZERO
        {true ,  "0_____________1", 0_____________1 }, // PLUS ONE
        {true ,  "0_377_7777_7777", 0_377_7777_7777 }, // MINUS ONE
        {true ,  "0____________13", 0____________13 },
        {true ,  "0___________263", 0___________263 },
        {true ,  "0_____1263_3232", 0_____1263_3232 },
        {true ,  "0_____2633_2211", 0_____2633_2211 },
        {true ,  "0________2_2635", 0________2_2635 },
        {true ,  "0_177_7777_7777", 0_177_7777_7777 }, // MAX
        {true ,  "0_200_0000_0000", 0_200_0000_0000 }, // MIN

        /* Out of bound */
        {false,  "0_400_0000_0000" , 0}, // Exceed MAX

        /*Binary Integer Literal ( 0 ~0b1111_1111_1111_1111_1111_1111_1111_1111 ) */
        {true , "0_0", 0b0}, // ZERO
        {true , "0_1", 0b1}, // PLUS ONE
        {true ,
            "0b1111_1111_1111_1111_1111_1111_1111_1111" ,
             0b1111_1111_1111_1111_1111_1111_1111_1111 }, // MINUS ONE
        {true ,
            "0b0001_0011_1100_1101_0010_0001_0101_1111" ,
             0b0001_0011_1100_1101_0010_0001_0101_1111 },
        {true ,
            "0b0111_1111_1111_1111_1111_1111_1111_1111" ,
             0b0111_1111_1111_1111_1111_1111_1111_1111 }, // MAX
        {true ,
            "0b1000_0000_0000_0000_0000_0000_0000_0000" ,
             0b1000_0000_0000_0000_0000_0000_0000_0000 }, // MIN

        /* Out of bound */
        {false,  "0b1_0000_0000_0000_0000_0000_0000_0000_0000" , 0}, // Exceed MAX

    });
  }

  @Before
  public void setUp() {
    System.out.println("START=============================================================================================================================");
    logger.info( this.testCode );
  }

  @org.junit.Test
  public void testRule() {

    String code = testCode;
    JavaParser parser = compiler(code);

    ParserRuleContext ruleContext = parser.literal();

    // VISITOR - CONTEXT CHECKER
    AstNode node = new AstBuilder().visitLiteral((JavaParser.LiteralContext) ruleContext);

    IntegerLiteral iLiteral = (IntegerLiteral) node;

    int result = iLiteral.getVal();

    // VISITOR - EXCEPTION INSPECTOR - Alert Error
    String exception = new ExceptionInspector().visitLiteral((JavaParser.LiteralContext) ruleContext);
    System.out.println( exception );

    if (this.testValid) {
      assertThat( result, is( equalTo(this.expectedResult) ) );

    } else {
      assertThat(exception, is( notNullValue() ) );

    }
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