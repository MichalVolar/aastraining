package tests;

import Utilities.Utils;
import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.SavingsCalculatorPage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmailVaildationTest extends TestBase {
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

    private List<String> readInvalidEmails() throws FileNotFoundException {
        FileReader invalidEmailsTxt = new FileReader(new File("src/test/resources/invalidEmails.txt"));
        List<String> invalidEmailList = new ArrayList<String>();
        invalidEmailList = new BufferedReader(invalidEmailsTxt).lines().collect(Collectors.<String>toList());
        return invalidEmailList;
    }


}




