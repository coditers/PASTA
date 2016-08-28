import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import codit.ast.compiler.Compiler;
import codit.ast.pojos.AstNode;

/**
 * @author Jay Lim
 * @since  8/28/2016
 */

@RunWith(Parameterized.class)
public class CompilerTest {

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\main\\java\\codit\\ast\\pojos\\AstNode.java",
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\AstNode.out.json"
        },
        {
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\main\\java\\codit\\ast\\pojos\\Modifiers.java",
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\Modifiers.out.json"
        },
        {
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\main\\java\\codit\\ast\\pojos\\packages\\PackageDeclaration.java",
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\PackageDeclaration.out.json"
        },
        {
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\codit-web\\src\\main\\java\\com\\estsoft\\codit\\web\\controller\\RecruitController.java",
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\RecruitController.out.json"
        },
        {
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\codit-web\\src\\main\\java\\com\\estsoft\\codit\\web\\interceptor\\AuthLoginInterceptor.java",
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\AuthLoginInterceptor.out.json"
        },
        {
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\codit-web\\src\\main\\java\\com\\estsoft\\codit\\db\\vo\\ApplicantVo.java",
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\ApplicantVo.out.json"
        },
        {
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\codit-web\\src\\main\\java\\com\\estsoft\\codit\\web\\annotation\\AuthClient.java",
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\AuthClient.out.json"
        },
        {
            "C:\\Users\\Jisung\\IdeaProjects\\study-archive\\study-dsa\\src\\main\\java\\io\\jaylim\\study\\dsa\\designpattern\\composite\\Graphic.java",
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\Graphic.out.json"
        },
        {
            "C:\\Users\\Jisung\\IdeaProjects\\study-archive\\study-dsa\\src\\main\\java\\io\\jaylim\\study\\dsa\\binarytree\\heap\\MaxHeap.java",
            "C:\\Users\\Jisung\\IdeaProjects\\codit\\j-compiler\\src\\test\\resources\\MaxHeap.out.json"
        },

    });
  }

  private final String sourceCodePath;
  private final String outputJsonPath;

  public CompilerTest(String sourceCodePath, String outputJsonPath) {
    this.sourceCodePath = sourceCodePath;
    this.outputJsonPath = outputJsonPath;
  }

  private Compiler compiler;

  @Before
  public void setUp() {
    compiler = new Compiler(sourceCodePath, outputJsonPath);
  }

  @Test
  public void TestCompiler() {
    AstNode astTree = compiler.compile();
    compiler.writeJsonFileOutput(astTree);

    assertThat(true, is(equalTo(true)));
  }
}
