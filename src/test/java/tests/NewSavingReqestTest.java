package tests;


import Utilities.Utils;
import base.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.SavingsCalculatorPage;

public class NewSavingReqestTest extends TestBase {

    @Test
    public void iTShouldDisplayTotalIncomeInNewRequest() {
        SavingsCalculatorPage calculatorPage = new SavingsCalculatorPage(driver);
        /// čast ARRANGE alebo GIVEN
        calculatorPage.selectFund("McDuck's safe");
        calculatorPage.onetimeInvestment("100");
        calculatorPage.enterAge("25");
        calculatorPage.enterEmail("m@v.sk");

        // precitat zo stranky total income
        String calculatedIncome = calculatorPage.getTotalIncome();
        //vytvorit novy saving request                                      /// čast ACT  alebo WHEN
        driver.findElement(By.cssSelector("button.btn-block")).click();
        //overit total income je zobrazeny
       // System.out.println(driver.findElement(By.xpath("//*[@id='app']/div/div[2]/ul/li/div/div/div[1]")).getText());  //vypise text celeho bloku
        //System.out.println(driver.findElement(By.xpath("//*[@id='app']/div/div[2]/ul/li/div/div/div[1]/p[1]/span")).getText()); //vypise konkretne total income
        //sout
        System.out.println(calculatorPage.getTABULA("//*[@id='app']/div/div[2]/ul/li/div/div")
                .findElement(By.xpath("./div[1]/p[1]/span"))
                .getText());
                                                                            /// čast ASSERT alebo THEN
        Assert.assertEquals(calculatedIncome, calculatorPage.getTABULA("//*[@id='app']/div/div[2]/ul/li/div/div/div[1]/p[1]/span").getText());
        //porovnanie calculated income s realnou hodnotou (assert equals) ktoru si vytiahol pomocou System.out.println...
        //pouzity xpath si zobral z browsra, takto vyzera ked pouzivas xpath helper //ul[contains(@class,'saving-list')]/li//div/p/span
        // do xpath helpera pises priamo HTML elementy, do hranatej zatvorky davas poradie //ul[contains(@class,'saving-list')]/li//div[contains(@class,'amount')]/p[2]/span['total']
        // a takto by to vyzeralo pomocou .findElement(By.cssSelector("ul.saving-list > li div.amounts > p > span"))
    }




    @Test
    public void itShouldDisplayFundInNewRequest(){
        SavingsCalculatorPage calculatorPage = new SavingsCalculatorPage(driver);
        String fundName = "McDuck's safe";
        calculatorPage.selectFund(fundName);
        calculatorPage.onetimeInvestment(String.valueOf(Utils.getRandomNumberInRange(10,500500)));
        calculatorPage.enterAge(String.valueOf(Utils.getRandomNumberInRange(10,100)));
        calculatorPage.enterEmail("m@v.sk");
        //vytvorit novy saving request
        driver.findElement(By.cssSelector("button.btn-block")).click();
        // precitat zo stranky popis fondu z druheho stlpca
        System.out.println(calculatorPage.getTABULA("//ul[contains(@class,'saving-list')]/li//div/p[contains(@class,'fund-description')]")
                .getText());
        //tu si si vytlacil nazov fondu ktory sa zobrazuje

        Assert.assertEquals(fundName, calculatorPage.getTABULA("//ul[contains(@class,'saving-list')]/li//div/p[contains(@class,'fund-description')]")
                .getText());
        //findElement(By.cssSelector(ul.saving-list > li > div.saving-detail)).findElement(By.cssSelector(p.fund-descrition))
        //takto si vies vytiahnut nejaku funkcnu cast a retazit za to dalsi findElement kde uz vytiahnes konkretnu vec. funguje aj kombinacia xpath,css
        // ked retazujes xpath tak do naviazaneho zacinas takto: .findElement(./p[contains(@class,'fund-description')]
        // ked mas error "cannot be referenced from a static content" checnki ci pouzivas spravny nazov na volanie metod,
        // nepouzivas nazov SavingsCalculatorPage ale ten co si si definoval --> SavingsCalculatorPage calculatorPage = new SavingsCalculatorPage(driver);
        // calculatorPage

    }

    @Test
    public void itSHouldDisplay20req(){
        SavingsCalculatorPage calculatorPage = new SavingsCalculatorPage(driver);

        for (int i = 0; i < 20; i++) {    ///fori
            String fundName = "McDuck's safe";
            calculatorPage.selectFund(fundName);
            calculatorPage.onetimeInvestment(String.valueOf(Utils.getRandomNumberInRange(10,500500)));
            calculatorPage.enterAge(String.valueOf(Utils.getRandomNumberInRange(10,100)));
            calculatorPage.enterEmail("m@v.sk");
            //vytvorit novy saving request
            driver.findElement(By.cssSelector("button.btn-block")).click();
        }

        driver.findElements(By.xpath("//ul[contains(@class,'saving-list')]/li//div"));

        System.out.println("covfefe");     //sout

        //skontroluj pocet ci sedi, ze si poslal 20 requestov
        Assert.assertEquals(20,driver.findElement(By.cssSelector("ul.saving-list>li>div.saving-detail")).getSize()
        );
    }

      ///alt+f8


}
