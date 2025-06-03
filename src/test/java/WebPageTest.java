import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebPageTest {
    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://mukund1046.github.io/Devops-2/");
    }

    @Test
    public void titleValidationTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Color Switch with Logo";
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

