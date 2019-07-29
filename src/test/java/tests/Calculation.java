package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Calculation {
    WebDriver driver;

    @Before                 //toto je anotacia
    public void setUp() {            // setUp je nazov lubovolny. do before si vytiahol otvaranie browsera ktore si mal v kazdej metode zvlast
        System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/savingscalculator.php");
    }


    @Test
    public void everyFund() {
        String[] fundsToSelect = {"Handelsbanken Aktiv 100","Hoggwart's Fund","Fellowship investment group","McDuck's safe",
                "Batman's Cave Development","Death Star real estate","Tom & Jerry corp"};
        for (String fundToSelect : fundsToSelect) {
            selectFund(fundToSelect);
            onetimeInvestment("100");
            enterAge("25");
            enterEmail("m@v.sk");
            Assert.assertFalse(getTotalIncome().isEmpty());      //nahradene metodou getTotalIncome()
            Assert.assertTrue(getInterestIncome());

            //System.out.println("hgu");  //printoval si string aby si zastavil debugger na tomto bode
        }

    }



///////// METODY

    private String getTotalIncome(){
        return driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[1]/p")).getText();
    }

    private boolean getInterestIncome(){
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[2]/p")).getText().isEmpty());
        return false;
    }

    private void selectFund(String fundToSelect){
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText(fundToSelect);
        //nahradil si tvrdy input premennou "fundToSelect"
        // vyberanie Fund z povodneho scriptu sme vytiahli von
        //private - viditelna iba vramci tejto class. public je viditelna pre cely projekt
        // void - nema ziadny output, iba vykona nejaky prikaz
    }

    private void onetimeInvestment(String amountToEnter){               //ideme nahradit kod ktory vklada sumu do fieldu one time investment
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys(amountToEnter);
    }

    private void enterAge(String age) {                     //nahradazam vyplnanie veku
        driver.findElement(By.id("yearsInput")).sendKeys(age);
    }

    private void enterEmail(String email) {                     //nahradzam vyplnenie mejlu
        driver.findElement(By.id("emailInput")).sendKeys(email);
    }


    @After
    public void tearDown() {              //do after si vytiahol zatvaranie browsera ktore si mal v kazdej metode zvlast.
        //Thread.sleep(500000000);         // pocka 5 sekund               // interupted exception ti pribudlo ked si povolil exception
        driver.close();
        driver.quit();
    }

}
