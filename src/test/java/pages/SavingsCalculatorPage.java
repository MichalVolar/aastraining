package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SavingsCalculatorPage {

private WebDriver pageDriver;

    public SavingsCalculatorPage(WebDriver driver) {            //pomocou constructora (alt+insert, vlozi ti kus kodu) vytvoris metodu na pomenovanie drivera
        this.pageDriver = driver;
    }

    public String getTotalIncome(){
        return pageDriver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[1]/p")).getText();
    }

      public boolean getInterestIncome(){
        Assert.assertFalse(pageDriver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[2]/p")).getText().isEmpty());
        return false;
    }

    public WebElement getTABULA(String s) {                    /// vytvoril si skratkou ctl+alt+M v sheete NewSaving
        return pageDriver.findElement(By.xpath(s));                 //// - potom si to mozes prehodit do Page so vsetkymi public metodami (cize sem)
    }

    public void selectFund(String fundToSelect){
        new Select(pageDriver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
        //nahradil si tvrdy input premennou "fundToSelect"
        // vyberanie Fund z povodneho scriptu sme vytiahli von
        //private - viditelna iba vramci tejto class. public je viditelna pre cely projekt
        // void - nema ziadny output, iba vykona nejaky prikaz
    }



    public void onetimeInvestment(String amountToEnter){               //ideme nahradit kod ktory vklada sumu do fieldu one time investment
        pageDriver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(amountToEnter);
    }

    public void enterAge(String age) {                     //nahradazam vyplnanie veku
        pageDriver.findElement(By.id("yearsInput")).sendKeys(age);
    }

    public void enterEmail(String email) {                     //nahradzam vyplnenie mejlu
        pageDriver.findElement(By.id("emailInput")).sendKeys(email);
    }








}
