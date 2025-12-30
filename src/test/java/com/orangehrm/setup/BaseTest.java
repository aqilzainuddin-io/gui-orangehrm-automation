package com.orangehrm.setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/**
 * BaseTest
 *
 * Base class for all test classes.
 * Handles WebDriver initialization, navigation, and cleanup.
 * Provides a shared `driver` instance for all tests that extend this class.
 */
public class BaseTest {

    // Protected WebDriver instance available to subclasses
    protected WebDriver driver;

    /**
     * Setup method executed before each test method.
     * - Initializes WebDriver using DriverFactory
     * - Navigates to the base URL from environment configuration
     * - Maximizes the browser window for consistency
     */
    @BeforeMethod
    public void setup() {
        // Initialize WebDriver
        driver = DriverFactory.initializeDriver();

        // Navigate to base URL from .env file
        driver.get(EnvReader.get("BASE_URL"));

        // Maximize window to avoid layout issues during tests
        driver.manage().window().maximize();
    }

    /**
     * Teardown method executed after each test method.
     * - Quits the WebDriver to ensure test isolation
     */
    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}