package codit.ast.pojos.literals;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

import codit.ast.builder.ContextChecker;
import codit.gencode.JavaLexer;
import codit.gencode.JavaParser;
import codit.strategy.ErrorInspectorStrategy;
import codit.visitor.ExceptionInspector;

/**
 * 
 * @author Jisung Lim <iejisung@gmail.com>
 */
@RunWith(Parameterized.class)
public class LiteralTest {
  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        /* String Literals. */
        {true,  "String literal1  = \"Hello Everybody!\";                                     " },
        {true,  "String literal2  = \"Hello Everybody, \\n I have some question.\";           " },
        {true,  "String literal3  = \"This works in Windows, \\r\\n stands for CRLF.\";       " },
        {true,  "String literal4  = \"This is tab, HERE->\\t<-HERE \";                        " },
        {true,  "String literal5  = \"We can put backslash character here -> \\\\ <-.\";      " },
        {true,  "String literal6  = \"\\\"Here is the one.\\\", \\\'Here is the other.\\\'\"; " },
        {true,  "String literal7  = \"Does backspace works? =>\\b<=\";                        " },
        {true,  "String literal8  = \"Does form feed works? =>\\f<=\";                        " },
        {true,  "String literal9  = \"It will disappear. \\r It will survive.\";              " },

        {false, "String literal10 = \"Error 1 : Quotation Mark -> \" <- \";                   " },
        {false, "String literal11 = \"Error 2 : Invalid Escape -> \\g <- \";                  " },

        /* Integer Literals (Decimal) */
        {true,  "int decimal1_int  = 0;                                                       " },
        {true,  "int decimal1_long = 0L;                                                      " },
        {true,  "int decimal2_int  = 12;                                                      " },
        {true,  "int decimal2_long = 12L;                                                     " },
        {true,  "int decimal3_int  = 1234_5678_9101;                                          " },
        {true,  "int decimal3_long = 1234_5678_9101L;                                         " },

        //{false, "int decimal4_int  = 0123;     Consumed as a Octal Integer Literal.           " },
        //{false, "int decimal4_long = 0123L;                                                   " },
        //{false, "int decimal5_int  = _123;     Consumed as a Expression Id.                   " },
        //{false, "int decimal5_long = _123L;                                                   " },
        {false, "int decimal6_int  = 123_;                                                    " },
        {false, "int decimal6_long = 123_L;                                                   " },

        /* Integer Literals (Hex) */
        {true,  "int hex1_int  = 0x0;                                                         " },
        {true,  "int hex1_long = 0x0L;                                                        " },
        {true,  "int hex2_int  = 0x12;                                                        " },
        {true,  "int hex2_long = 0x12L;                                                       " },
        {true,  "int hex3_int  = 0x1234_5678;                                                 " },
        {true,  "int hex3_long = 0x1234_5678L;                                                " },

        {false, "int hex4_int  = 0x_0123;                                                     " },
        {false, "int hex4_long = 0x_0123L;                                                    " },
        {false, "int hex5_int  = 0x123_;                                                      " },
        {false, "int hex5_long = 0x123_L;                                                     " },
        
        /* Integer Literals (Octal) */
        {true,  "int octal1_int  = 00;                                                        " },
        {true,  "int octal1_long = 00L;                                                       " },
        {true,  "int octal2_int  = 012;                                                       " },
        {true,  "int octal2_long = 012L;                                                      " },
        {true,  "int octal3_int  = 01234_567;                                                 " },
        {true,  "int octal3_long = 01234_567L;                                                " },
        {true,  "int octal4_int  = 00123;                                                     " },
        {true,  "int octal4_long = 00123L;                                                    " },

        {true,  "int octal1_int  = 0_0;                                                       " },
        {true,  "int octal1_long = 0_0L;                                                      " },
        {true,  "int octal2_int  = 0_12;                                                      " },
        {true,  "int octal2_long = 0_12L;                                                     " },
        {true,  "int octal3_int  = 0_1234_567;                                                " },
        {true,  "int octal3_long = 0_1234_567L;                                               " },
        {true,  "int octal4_int  = 0_0123;                                                    " },
        {true,  "int octal4_long = 0_0123L;                                                   " },

        {false, "int octal5_int  = 0_1238;                                                    " },
        {false, "int octal5_long = 0_1238L;                                                   " },
        {false, "int octal5_int  = 0_123_;                                                    " },
        {false, "int octal5_long = 0_123_L;                                                   " },

        /* Integer Literals (Binary) */
        {true,  "int binary1_int  = 0b0;                                                       " },
        {true,  "int binary1_long = 0b0L;                                                      " },
        {true,  "int binary2_int  = 0b101;                                                     " },
        {true,  "int binary2_long = 0b101L;                                                    " },
        {true,  "int binary3_int  = 0b1010_1110;                                               " },
        {true,  "int binary3_long = 0b1010_1110L;                                              " },

        {false, "int binary4_int  = 0b_0101;                                                   " },
        {false, "int binary4_long = 0b_0101L;                                                  " },
        {false, "int binary5_int  = 0b110_;                                                    " },
        {false, "int binary5_long = 0b110_L;                                                   " }
    });
  }

  private static final Logger logger = LoggerFactory.getLogger(LiteralTest.class);

  private final boolean testValid;
  private StringBuilder testCode;

  public LiteralTest(boolean testValid, String testString) {
    this.testValid = testValid;
    this.testCode = new StringBuilder("");

    testCode.append("public class TestLiteral { public static void main(String[] args) {");
    this.testCode.append(testString);
  }

  @Before
  public void setUp() {
    testCode.append("}}");

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

  @org.junit.Test
  public void testRule() {
    System.out.println("START=============================================================================================================================");
    logger.info( this.testCode.toString() );
    String code = testCode.toString();
    JavaParser parser = compiler(code);

    ParserRuleContext ruleContext = parser.compilationUnit();

    // VISITOR - CONTEXT CHECKER
    new ContextChecker().visitCompilationUnit((JavaParser.CompilationUnitContext) ruleContext);

    // VISITOR - EXCEPTION INSPECTOR
    String exception = new ExceptionInspector().visitCompilationUnit((JavaParser.CompilationUnitContext) ruleContext);

    System.out.println( exception );
    if (this.testValid) {
      assertThat(exception, is( nullValue() ) );
    } else {
      assertThat(exception, is( notNullValue() ) );
    }

//    logger.info( ruleContext.toStringTree((Arrays.asList(JavaParser.ruleNames))) + " : " + ruleContext.toInfoString(parser) + " ::: " + ruleContext.children );
    System.out.println("===============================================================================================================================END");
  }
}
