package com.orangehrm.setup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * DriverFactory
 *
 * Responsible for:
 * - Creating a single WebDriver instance (Singleton-style)
 * - Handling browser configuration (headless / normal)
 * - Managing driver lifecycle (init & quit)
 */
public class DriverFactory {

    // Shared WebDriver instance for the test execution
    private static WebDriver driver;

    /**
     * Initialize and return WebDriver instance.
     * If driver already exists, reuse it.
     *
     * @return WebDriver
     */
    public static WebDriver initializeDriver() {

        // Create driver only once
        if (driver == null) {

            // Chrome browser configuration
            ChromeOptions options = new ChromeOptions();

            // Enable headless mode if specified in environment config
            if ("true".equalsIgnoreCase(EnvReader.get("HEADLESS"))) {
                options.addArguments("--headless=new");
            }

            // Initialize ChromeDriver with options
            driver = new ChromeDriver(options);

            // Global implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Maximize browser window for consistency
            driver.manage().window().maximize();
        }

        return driver;
    }

    /**
     * Quit WebDriver and clean up instance.
     * This ensures browser is properly closed after test execution.
     */
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // reset driver for next run
        }
    }
}
