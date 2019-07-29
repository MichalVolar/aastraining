package tests;


import Base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;                   // tu importujes WebDriver class ktory pouzivas v celom scripte
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CalculationTest extends TestBase {
    private WebDriver driver = new ChromeDriver();             // toto si premenovavas class ktory importujes zo selenia na driver aby si to nemusel vypisovat. driver je premenna

    @Before                 //toto je anotacia
    public void setUp() {            // setUp je nazov lubovolny. do before si vytiahol otvaranie browsera ktore si mal v kazdej metode zvlast
        System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
        driver.get("http://localhost/savingscalculator.php");
    }

    @Test
    public void itShouldCalculateTotalIncome() {
        //vybrat fond,sumu,roky,email
        //vybrat fond
        //new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
        // Select je zo selenia, treba alt+enter, potom vyberas podla "visibleText" co sa zobrazuje v comboboxe
        selectFund("McDuck's safe");
        //zadat sumu
        //driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("100");
        onetimeInvestment("100");
        //zadat pocet rokov
        //driver.findElement(By.id("yearsInput")).sendKeys("20");
        enterAge("25");
        //zadat email - najde pole
        //driver.findElement(By.id("emailInput")).sendKeys("m@v.sk");
        enterEmail("m@v.sk");


        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

        //overit ze total income nieje prazdny              //div.result > div:nth-child(3) > p --- child pod div, element p -> poradie 3
        driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[1]/p"));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[1]/p")).getText().isEmpty());

    }

    @Test
    public void itShouldCalculateInterestIncome() {
        selectFund("Hoggwart's Fund");  //toto su metody, som nahradil predosly kod viem tam nahodit konkretny string ktory sa ma vybrat
        onetimeInvestment("20");
        enterAge("35") ;
        enterEmail("j@v.sk");

        //overuje ci je button active
        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

        //overit ze interest income nieje prazdny, posledny overuje ci je tam "kr"
        driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[2]/p"));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[2]/p")).getText().isEmpty());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[2]/p")).getText().contains("kr"));
    }

    @Test
    public void itShouldCalculateRisk() {
        //vybrat fond,sumu,roky,email
        //vybrat fond
        //new Select(driver.findElement(By.id("fundSelect"))).selectByVisibleText("Hoggwart's Fund");
        // Select je zo selenia, treba alt+enter, potom vyberas podla "visibleText" co sa zobrazuje v comboboxe
        //nahradil si metodou z konca, mozes vlozit konkretny string
        selectFund("Fellowship investment group");


        //zadat sumu
        //driver.findElement(By.id("oneTimeInvestmentInput")).sendKeys("100");
        onetimeInvestment("10");

        //zadat pocet rokov
        //driver.findElement(By.id("yearsInput")).sendKeys("20");
        enterAge("45");

        //zadat email - najde pole
        //driver.findElement(By.id("emailInput")).sendKeys("m@v.sk");
        enterEmail("w@v.sk");

        Assert.assertTrue(driver.findElement(By.cssSelector("button.btn-block")).isEnabled());

        //overit ze risk nieje prazdny
        driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[3]/p"));
        Assert.assertFalse(driver.findElement(By.xpath("//*[@id='app']/div/div[1]/div[5]/div[3]/p")).getText().isEmpty());
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

    @Test
    public void everyFund() {
        String[] fundsToSelect = {"Handelsbanken Aktiv 100","Hoggwart's Fund","Fellowship investment group","McDuck's safe",
                "Batman's Cave Development","Death Star real estate","Tom & Jerry corp"};
        for (String fundToSelect : fundsToSelect) {
            System.out.println(fundToSelect);
        }

    }



    @After
    public void tearDown() {              //do after si vytiahol zatvaranie browsera ktore si mal v kazdej metode zvlast.
        //Thread.sleep(500000000);         // pocka 5 sekund               // interupted exception ti pribudlo ked si povolil exception
        driver.close();
        driver.quit();
    }
            //alt+f8 vies spustit evaluate

}
