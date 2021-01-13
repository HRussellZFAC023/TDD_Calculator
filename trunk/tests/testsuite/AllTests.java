package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test.AStackShouldBeAbleTo;
import test.AnEntryObjectShouldBeAbleTo;
import test.OpTestType;
import test.TestCalcFactory;
import test.TestInfixCalc;
import test.TestPostfixCalc;
import test.TestSymbol;
import test.TestType;
import test.TheModelShouldBeAbleTo;

/**
 * Used to run all the tests in the test package in succession.
 * 
 * @author eclipse
 */
@RunWith(Suite.class)
@SuiteClasses({TheModelShouldBeAbleTo.class, AnEntryObjectShouldBeAbleTo.class,
    AStackShouldBeAbleTo.class, TestType.class, OpTestType.class, TestSymbol.class, TestType.class,
    TestCalcFactory.class, TestInfixCalc.class, TestPostfixCalc.class})
public class AllTests {
}
