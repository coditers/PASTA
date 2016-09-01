package io.jaylim.compiler.strategy;

import org.antlr.v4.runtime.DefaultErrorStrategy;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;

/**
 * @author Jisung Lim <iejisung@gmail.com>
 */
public class ErrorInspectorStrategy extends DefaultErrorStrategy {
  @Override
  public void reportError(Parser recognizer,
                          RecognitionException e)
  {
    // if we've already reported an error and have not matched a token
    // yet successfully, don't report any errors.
    if (inErrorRecoveryMode(recognizer)) {
//      System.err.print("[SPURIOUS] ");
      return; // don't report spurious errors
    }
    beginErrorCondition(recognizer);
    if ( e instanceof NoViableAltException) {
      reportNoViableAlternative(recognizer, (NoViableAltException) e);
    }
    else if ( e instanceof InputMismatchException) {
      reportInputMismatch(recognizer, (InputMismatchException)e);
    }
    else if ( e instanceof FailedPredicateException) {
      reportFailedPredicate(recognizer, (FailedPredicateException)e);
    }
    else {
      System.err.println("unknown recognition error type: "+e.getClass().getName());
      recognizer.notifyErrorListeners(e.getOffendingToken(), e.getMessage(), e);
      System.out.println("REPORT_UNKNOWN_ERROR");
    }
  }

  @Override
  protected void reportMissingToken(Parser recognizer) {
    super.reportMissingToken(recognizer);
    System.out.println("REPORT_MISSING_TOKEN");
  }

  @Override
  protected void reportUnwantedToken(Parser recognizer) {
    super.reportUnwantedToken(recognizer);
    System.out.println("REPORT_UNWANTED_TOKEN");

  }

  @Override
  protected void reportFailedPredicate(Parser recognizer, FailedPredicateException e) {
    super.reportFailedPredicate(recognizer, e);
    System.out.println("REPORT_FAILED_PREDICATE");

  }

  @Override
  protected void reportInputMismatch(Parser recognizer, InputMismatchException e) {
    super.reportInputMismatch(recognizer, e);
    System.out.println("REPORT_INPUT_MISMATCH");

  }

  @Override
  protected void reportNoViableAlternative(Parser recognizer, NoViableAltException e) {
    super.reportNoViableAlternative(recognizer, e);
    System.out.println("REPORT_NO_VIABLE_ALTERNATIVE");

  }
}
