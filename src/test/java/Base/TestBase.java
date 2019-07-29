package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
WebDriver driver;

    @Before                 //toto je anotacia
    public void setUp() {            // setUp je nazov lubovolny. do before si vytiahol otvaranie browsera ktore si mal v kazdej metode zvlast
        System.setProperty("webDriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost/savingscalculator.php");
    }

    @After
    public void tearDown() {              //do after si vytiahol zatvaranie browsera ktore si mal v kazdej metode zvlast.
        //Thread.sleep(500000000);         // pocka 5 sekund               // interupted exception ti pribudlo ked si povolil exception
        driver.close();
        driver.quit();
    }



}
