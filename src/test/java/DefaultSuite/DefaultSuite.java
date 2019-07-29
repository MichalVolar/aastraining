package DefaultSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.CalculationTest;
import tests.SavingCalculatorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
SavingCalculatorTest.class,
CalculationTest.class
})

public class DefaultSuite {


}
