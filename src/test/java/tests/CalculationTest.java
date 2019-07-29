package tests;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;                   // tu importujes WebDriver class ktory pouzivas v celom scripte
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CalculationTest {
    WebDriver driver;             // toto si premenovavas class ktory importujes zo selenia na driver aby si to nemusel vypisovat. driver je premenna

    @Before                 //toto je anotacia
    public void setUp() {            // setUp je nazov lubovolny. do before si vytiahol otvaranie browsera ktore si mal v kazdej metode zvlast
        System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/savingscalculator.php");
    }

    @Test
    public void itShouldCalculateTotalIncome() {
        //vybrat fond,sumu,roky,email
        //vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
        // Select je zo selenia, treba alt+enter, potom vyberas podla "visibleText" co sa zobrazuje v comboboxe

        //zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("100");
        //zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("20");
        //zadat email - najde pole
        driver.findElement(By.id("emailInput")).sendKeys("m@v.sk");

        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

        //overit ze total income nieje prazdny              //div.result > div:nth-child(3) > p --- child pod div, element p -> poradie 3
        driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[1]/p"));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[1]/p")).getText().isEmpty());

    }

    @Test
    public void itShouldCalculateInterestIncome() {
        //vybrat fond,sumu,roky,email
        //vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
        // Select je zo selenia, treba alt+enter, potom vyberas podla "visibleText" co sa zobrazuje v comboboxe

        //zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("100");
        //zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("20");
        //zadat email - najde pole
        driver.findElement(By.id("emailInput")).sendKeys("m@v.sk");

        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

        //overit ze interest income nieje prazdny
        driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[2]/p"));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[2]/p")).getText().isEmpty());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[2]/p")).getText().contains("kr"));


    }

    @Test
    public void itShouldCalculateRisk() {
        //vybrat fond,sumu,roky,email
        //vybrat fond
        new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
        // Select je zo selenia, treba alt+enter, potom vyberas podla "visibleText" co sa zobrazuje v comboboxe

        //zadat sumu
        driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("100");
        //zadat pocet rokov
        driver.findElement(By.id("yearsInput")).sendKeys("20");
        //zadat email - najde pole
        driver.findElement(By.id("emailInput")).sendKeys("m@v.sk");

        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

        //overit ze risk nieje prazdny
        driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[3]/p"));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[3]/p")).getText().isEmpty());
    }


    @After
    public void tearDown() throws InterruptedException {              //do after si vytiahol zatvaranie browsera ktore si mal v kazdej metode zvlast.
        Thread.sleep(5000);         // pocka 5 sekund
        driver.close();
        driver.quit();
    }


}
