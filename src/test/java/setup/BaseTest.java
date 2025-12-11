package setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        // Initialize WebDriver (you already have this in DriverFactory)
        driver = DriverFactory.initializeDriver();

        // Navigate to the base URL (from your .env or config)
        driver.get(EnvReader.get("BASE_URL"));

        // Optional: maximize the browser for stability
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        // Quit driver after each test to keep tests isolated
        DriverFactory.quitDriver();
    }
}
