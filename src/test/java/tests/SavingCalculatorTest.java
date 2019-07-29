package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SavingCalculatorTest {
    WebDriver driver;
    //vytiahol si tento webdriver z metod do class aby to vedeli pouzivat vsetky metody v tejto class

    @Before                 //toto je anotacia
    public void setUp(){            // setUp je nazov lubovolny. do before si vytiahol otvaranie browsera ktore si mal v kazdej metode zvlast
        System.setProperty("webDriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/savingscalculator.php");
    }


    @Test
    public void itShouldDisplayTitle(){


    driver.findElement(By.cssSelector("h1")).getText();
    Assert.assertEquals("Savings Calculator", driver.findElement(By.cssSelector("h1")).getText());

    }

    @Test
    public void itShouldDisableApplyButtonOnPageOpen() {

        driver.findElement(By.cssSelector("button.btn-block")).isEnabled();
        Assert.assertFalse(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

    }

    @Test
    public void itShouldEnableApplyButton(){
        //vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
               // Select je zo selenia, treba alt+enter, potom vyberas podla "visibleText" co sa zobrazuje v comboboxe

        //zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("100");
        //zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("20");
        //zadat email - najde pole
        driver.findElement(By.id("emailInput")).sendKeys("m@v.sk");

        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());      //overit button
    }


    @Test
    public void itShouldNotSelectAyFundOnPageOpen(){
        new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText();  // vrati text prvej zvolenej moznosti
        // System.out.println(new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());   //vrati text
        Assert.assertEquals("Select your fund",
                new Select(driver.findElement(By.id("fundSelect"))).getFirstSelectedOption().getText());
    }





    @After
    public void tearDown(){              //do after si vytiahol zatvaranie browsera ktore si mal v kazdej metode zvlast.
        driver.close();
        driver.quit();
    }


}
