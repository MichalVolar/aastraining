package tests;

import Utilities.Utils;
import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.SavingsCalculatorPage;

public class emailVaildationTest extends TestBase {
    @Test
    public void itShouldDisplayErrorWhenEmailIsInvalid() {
        SavingsCalculatorPage calculatorPage = new SavingsCalculatorPage(driver);

        calculatorPage.enterEmail("abc");
        Assert.assertTrue(driver.findElement(By.xpath("//div[input[@id='emailInput']]"))
                .getAttribute("class")
                .contains("error"));

        //vytvorit novy saving request
        System.out.println("break");
        driver.findElement(By.cssSelector("button.btn-block")).isEnabled();


    }
}
