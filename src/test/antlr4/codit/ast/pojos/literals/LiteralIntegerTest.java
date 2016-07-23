package codit.ast.pojos.literals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

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
  private final int expectedValue;

  // Constructors
  public LiteralIntegerTest(boolean testValid,
                            String testValue,
                            int expectedValue) {
    // Test valid
    this.testValid = testValid;

    // Test value
    this.testValue = testValue;

    // Expected value
    this.expectedValue = expectedValue;
  }

  // Parameterized values
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        /* valid, rawString, expectedValue */

        /* Decimal Integer Literal ( -2,147,483,648 ~ 2,147,483,647 ) */
        {true ,  "0" ,  0 , false }, // ZERO
        {true ,  "1" ,  1 , false }, // PLUSONE
        {true , "-1" , -1 , false }, // MINUS ONE

        {true ,   "1263_3232" ,    12633232 , false }, // under bar 1
        {true ,   "2_2_6_3_5" ,       22635 , false }, // under bar 2

        {true ,  "2147483647" ,  2147483647 , false }, // MAX
        {true , "-2147483648" , -2147483648 , false }, // MIN

        /* Error case */
        {false,   "213212abf" , 0, false}, // Unpredictable character
        {false,  "2147483648" , 0, false}, // Exceed MAX
        {false, "-2147483649" , 0, false}, // Exceed MIN


        /* Decimal Long Literal ( -9,223,372,036,854,775,808 ~ 9,223,372,036,854,775,807 ) */
        {true ,                    "0L" ,                    0L , true }, // ZERO
        {true ,                    "1L" ,                    1L , true }, // PLUSONE
        {true ,                   "-1L" ,                   -1L , true }, // MINUS ONE

        {true ,            "1263_3232L" ,             12633232L , true }, // under bar 1
        {true ,            "2_2_6_3_5L" ,                22635L , true }, // under bar 2

        {true ,  "9223372036854775807L" ,  9223372036854775807L , true }, // MAX
        {true , "-9223372036854775808L" , -9223372036854775808L , true }, // MIN

        /* Out of bound */
        {false ,   "12412412412222awf2L" , 0 , false }, // Unpredictable character
        {false ,  "9223372036854775808L" , 0 , false }, // Exceed MAX
        {false , "-9223372036854775809L" , 0 , false }, // Exceed MIN



        /* Hexadecimal Integer Literal ( 0 ~ 0xFFFFFFFF ) */
        {true ,  "0x0_______0"  , 0x0_______0 , false },  // ZERO
        {true ,  "0x0_______1"  , 0x0_______1 , false },  // PLUS ONE
        {true ,  "0xFFFF_FFFF"  , 0xFFFF_FFFF , false },  // MINUS ONE

        {true ,  "0x0_B_fF1a3"  , 0x0_B_fF1a3 , false },  // under bar 1
        {true ,  "0x2226_2335"  , 0x2226_2335 , false },  // under bar 2

        {true ,  "0x7FFF_FFFF"  , 0x7FFF_FFFF , false },  // MAX
        {true ,  "0x8000_0000"  , 0x8000_0000 , false },  // MIN

        /* Out of bound */
        {false,  "0x__1GFA_0000" , 0, false}, // Unexpected char
        {false,  "0x1_0000_0000" , 0, false}, // Exceed MAX


        /* Hexadecimal Long Literal ( 0 ~ 0xFFFFFFFFFFFFFFFFL ) */
        {true ,  "0x0000_0000_0000_0000L"  , 0x0000_0000_0000_0000L , true },  // ZERO
        {true ,  "0x0000_0000_0000_0001L"  , 0x0000_0000_0000_0001L , true },  // PLUS ONE
        {true ,  "0xFFFF_FFFF_FFFF_FFFFL"  , 0xFFFF_FFFF_FFFF_FFFFL , true },  // MINUS ONE

        {true ,  "0x0_B_fF1a3L"  , 0x0_B_fF1a3L , true },  // under bar 1
        {true ,  "0x2226_2335L"  , 0x2226_2335L , true },  // under bar 2

        {true ,  "0x7FFF_FFFF_FFFF_FFFFL"  , 0x7FFF_FFFF_FFFF_FFFFL , true },  // MAX
        {true ,  "0x8000_0000_0000_0000L"  , 0x8000_0000_0000_0000L , true },  // MIN

        /* Out of bound */
        {false,  "0x____________1GFA_0000L" , 0, false}, // Unexpected char
        {false,  "0x1_0000_0000_0000_0000L" , 0, false}, // Exceed MAX



        /* Octal Integer Literal ( 0 ~ 0_377_7777_7777 ) */
        {true ,  "0_000_0000_0000", 0_000_0000_0000 , false }, // ZERO
        {true ,               "00",              00 , false }, // ANOTHER ZERO
        {true ,  "0_000_0000_0001", 0_000_0000_0001 , false }, // PLUS ONE
        {true ,  "0_377_7777_7777", 0_377_7777_7777 , false }, // MINUS ONE

        {true ,  "0_000_0000_0263", 0_000_0000_0263 , false }, // under bar 1
        {true ,  "0_2_63_3_2__211", 0_2_63_3_2__211 , false }, // under bar 2

        {true ,  "0_177_7777_7777", 0_177_7777_7777 , false }, // MAX
        {true ,  "0_200_0000_0000", 0_200_0000_0000 , false }, // MIN

        /* Out of bound */
        {false,  "0_000_0080_0263", 0, false}, // Unexpected char
        {false,  "0_400_0000_0000", 0, false}, // Exceed MAX


        /* Octal Long Literal ( 0 ~ 0_17_7777_7777_7777_7777_7777L ) */
        {true ,  "0_00_0000_0000_0000_0000_0000L", 0_00_0000_0000_0000_0000_0000L , true }, // ZERO
        {true ,                             "00L",                            00L , true }, // ANOTHER ZERO
        {true ,  "0_00_0000_0000_0000_0000_0001L", 0_00_0000_0000_0000_0000_0001L , true }, // PLUS ONE
        {true ,  "0_17_7777_7777_7777_7777_7777L", 0_17_7777_7777_7777_7777_7777L , true }, // MINUS ONE

        {true ,  "0_000_0000_0263L", 0_000_0000_0263L , true },
        {true ,  "0_2_63_3_2__211L", 0_2_63_3_2__211L , true },

        {true ,  "0_07_7777_7777_7777_7777_7777L", 0_07_7777_7777_7777_7777_7777L , true }, // MAX
        {true ,  "0_10_0000_0000_0000_0000_0000L", 0_10_0000_0000_0000_0000_0000L , true }, // MIN

        /* Out of bound */
        {false,  "0_20_0000_0080_0000_0000_0000L" , 0, false}, // Unexpected char
        {false,  "0_20_0000_0000_0000_0000_0000L" , 0, false}, // Exceed MAX



        /* Binary Integer Literal ( 0 ~0b1111_1111_1111_1111_1111_1111_1111_1111 ) */
        {true , "0_0", 0b0, false}, // ZERO
        {true , "0_1", 0b1, false}, // PLUS ONE
        {true ,
            "0b1111_1111_1111_1111_1111_1111_1111_1111" ,
             0b1111_1111_1111_1111_1111_1111_1111_1111, false }, // MINUS ONE
        
        {true ,
            "0b0001_0011_1100_1101_0010_0001_0101_1111" ,
             0b0001_0011_1100_1101_0010_0001_0101_1111, false },
        {true ,
            "0b1__1___11_11___11_1___1_____1__1_1_1111" ,
             0b1__1___11_11___11_1___1_____1__1_1_1111, false },
        
        {true ,
            "0b0111_1111_1111_1111_1111_1111_1111_1111" ,
             0b0111_1111_1111_1111_1111_1111_1111_1111, false }, // MAX
        {true ,
            "0b1000_0000_0000_0000_0000_0000_0000_0000" ,
             0b1000_0000_0000_0000_0000_0000_0000_0000, false }, // MIN

        /* Out of bound */
        {false ,   "0b___1___11_11___11_1___1_____1__1_1_1111" , 0, false }, // Unexpected char
        {false , "0b1_0000_0000_0000_0000_0000_0000_0000_0000" , 0, false }, // Exceed MAX


        /* Binary Long Literal ( 0 ~0b1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111 ) */
        {true , "0_0L", 0b0L, true}, // ZERO
        {true , "0_1L", 0b1L, true}, // PLUS ONE
        {true ,
            "0b1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L" ,
            0b1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L , true}, // MINUS ONE

        {true ,
            "0b0001_0011_1100_1101_0010_0001_0101_1111L" ,
             0b0001_0011_1100_1101_0010_0001_0101_1111L , true},
        {true ,
            "0b1__1___11_11___11_1___1_____1__1_1_1111L" ,
             0b1__1___11_11___11_1___1_____1__1_1_1111L, true },

        {true ,
            "0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L" ,
             0b0111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111_1111L , true}, // MAX
        {true ,
            "0b1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L" ,
            0b1000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L , true}, // MIN

        /* Out of bound */
        {false ,   "0b___1___11_11___11_1___1_____1__1_1_1111L" , 0 , false }, // Unexpected char
        {false,  "0b1_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000_0000L" , 0 , false }, // Exceed MAX

    });
  }

  @Before
  public void setUp() {
    System.out.println("START=============================================================================================================================");
    logger.info( this.testValue );
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

    if (this.testValid) {
      assertThat( iLiteral, is( equalTo(expectedLiteral) ) );

    } else {
      assertThat(true, is( true ) );

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