package setup;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        if (driver == null) {
            String browser = EnvReader.get("BROWSER");
            if (browser == null || browser.isEmpty()) {
                browser = "chrome";
            }

            switch (browser.toLowerCase()) {
                case "chrome":
                default:
                    ChromeOptions options = new ChromeOptions();
                    if ("true".equalsIgnoreCase(EnvReader.get("HEADLESS")) 
                        || System.getenv("GITHUB_ACTIONS") != null) {
                        
                        options.addArguments("--headless=new");
                        options.addArguments("--no-sandbox");
                        options.addArguments("--disable-dev-shm-usage");
                        options.addArguments("--disable-gpu");
                        options.addArguments("--disable-extensions");
                        options.addArguments("--remote-debugging-port=9222");
                    }
                    
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}