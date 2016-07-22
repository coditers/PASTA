package codit.ast.pojos.literals;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */

@RunWith(Parameterized.class)
public class LiteralIntegerTest {

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
        {""}
    });
  }

}
