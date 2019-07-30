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
        //sout

        Assert.assertEquals(calculatedIncome,driver.findElement(By.xpath("//*[@id='app']/div/div[2]/ul/li/div/div/div[1]/p[1]/span")).getText());
        //porovnanie calculated income s realnou hodnotou (assert equals) ktoru si vytiahol pomocou System.out.println...
        //pouzity xpath si zobral z browsra, takto vyzera ked pouzivas xpath helper //ul[contains(@class,'saving-list')]/li//div/p/span
        // do xpath helpera pises priamo HTML elementy, do hranatej zatvorky davas poradie //ul[contains(@class,'saving-list')]/li//div[contains(@class,'amount')]/p[2]/span['total']
        // a takto by to vyzeralo pomocou .findElement(By.cssSelector("ul.saving-list > li div.amounts > p > span"))

    }


}
