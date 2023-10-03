import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;


public class BaseTest {
    protected WebDriver driver;

    @Before
    public void startBrowser() {
        WebDriverFactory webDriverFactory = new WebDriverFactory();
        driver = webDriverFactory.getWebDriver("chrome");
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser() {
        driver.quit();
    }


}
