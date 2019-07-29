package tests;

import.org.junit.runner.RunWith;
import.org.junit.runners.Suites;

import org.graalvm.compiler.phases.tiers.Suites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.CalculationTest;
import tests.SavingCalculatorTest;

    @RunWith(Suites.class)
    @Suite.SuiteClasses({
            SavingCalculatorTest.class,
            CalculationTest.class
    })

public class DefaultSuite {


}
