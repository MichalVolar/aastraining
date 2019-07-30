package tests;

import Utilities.Utils;
import base.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.SavingsCalculatorPage;

public class emailVaildationTest extends TestBase {
    @Test
    public void itShouldDisplayErrorWhenEmailIsInvalid() {
        SavingsCalculatorPage calculatorPage = new SavingsCalculatorPage(driver);

        calculatorPage.enterEmail("abc");


        //vytvorit novy saving request
        driver.findElement(By.cssSelector("button.btn-block")).isEnabled();


    }
}
