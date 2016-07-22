package codit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.TokenStream;
import org.junit.After;
import org.junit.Before;

import codit.visitor.ContextChecker;
import codit.gencode.JavaLexer;
import codit.gencode.JavaParser;
import codit.strategy.ErrorInspectorStrategy;
import codit.visitor.ExceptionInspector;

/**
 *
 * Created by Jisung on 7/19/2016.
 */

public class Test {

  private String code;

  @Before
  public void setUp() {
    System.out.println("START=============================================================================================================================");

  }

  private JavaParser compiler(String code) {

    ANTLRInputStream input = new ANTLRInputStream( code );
    JavaLexer lexer = new JavaLexer(input);
    TokenStream tokens = new CommonTokenStream(lexer);

    JavaParser parser = new JavaParser(tokens);
    double f = 3.;
    float ft = 0x23.2p-111f;
    parser.setBuildParseTree(true);

    // LISTENER - LOGGER
//    parser.addParseListener(new LoggingListener());
    parser.setErrorHandler(new ErrorInspectorStrategy());
    return parser;
  }

  @org.junit.Test
  public void testRule() {
    String code = "0x12315_1232L";
    JavaParser parser = compiler(code);

    ParserRuleContext ruleContext = parser.literal();

    // VISITOR - CONTEXT CHECKER
    new ContextChecker().visitLiteral((JavaParser.LiteralContext) ruleContext);

    // VISITOR - EXCEPTION INSPECTOR
    String exception = new ExceptionInspector().visitLiteral((JavaParser.LiteralContext) ruleContext);

    System.out.println( exception );
    if (true) {
      assertThat(exception, is( nullValue() ) );
    } else {
      assertThat(exception, is( notNullValue() ) );
    }

//    logger.info( ruleContext.toStringTree((Arrays.asList(JavaParser.ruleNames))) + " : " + ruleContext.toInfoString(parser) + " ::: " + ruleContext.children );
  }

  @After
  public void shutDown() {
    System.out.println("===============================================================================================================================END");
  }
}
