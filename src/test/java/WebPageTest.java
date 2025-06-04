import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebPageTest {

    private static WebDriver driver;

    @BeforeTest
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();


        // ✅ FIX for DevToolsActivePort error in WSL
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-debugging-port=9222");
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--disable-setuid-sandbox");
        options.addArguments("--disable-extensions");
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
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

