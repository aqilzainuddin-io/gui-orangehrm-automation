package com.orangehrm.setup;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        if (driver == null) {
            
            ChromeOptions options = new ChromeOptions();
            
            if ("true".equalsIgnoreCase(EnvReader.get("HEADLESS"))) {
                options.addArguments("--headless=new");
            }
            
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
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