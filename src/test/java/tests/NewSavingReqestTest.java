package tests;


import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.SavingsCalculatorPage;

public class NewSavingReqestTest extends TestBase {

    @Test
    public void iTShouldDisplayTotalIncomeInNewRequest() {
        SavingsCalculatorPage calculatorPage = new SavingsCalculatorPage(driver);

        calculatorPage.selectFund("McDuck's safe");
        calculatorPage.onetimeInvestment("100");
        calculatorPage.enterAge("25");
        calculatorPage.enterEmail("m@v.sk");

        // precitat zo stranky total income
        String calculatedIncome = calculatorPage.getTotalIncome();


        //vytvorit novy saving request
        driver.findElement(By.cssSelector("button.btn-block")).click();

        //overit total income je zobrazeny
       // System.out.println(driver.findElement(By.xpath("//*[@id='app']/div/div[2]/ul/li/div/div/div[1]")).getText());  //vypise text celeho bloku
        System.out.println(driver.findElement(By.xpath("//*[@id='app']/div/div[2]/ul/li/div/div/div[1]/p[1]/span")).getText()); //vypise konkretne total income

        Assert.assertEquals(calculatedIncome,driver.findElement(By.xpath("//*[@id='app']/div/div[2]/ul/li/div/div/div[1]/p[1]/span")).getText());
        //porovnanie calculated income s realnou hodnotou ktoru si vytiahol pomocou System.out.println...

        //

    }


}
