package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;

/**
 * BasePage serves as the parent class for all page classes.
 * It provides common WebDriver actions (click, type, getText, etc.)
 * and reusable wait methods to handle synchronization issues.
 * 
 * This class implements the foundation of the Page Object Model (POM).
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor initializes WebDriver and WebDriverWait.
     * The explicit wait is set to 10 seconds for element interactions.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    /**
     * Checks whether the element is displayed on the page.
     * Returns false if the element is not found.
     */
    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Waits for the element to be visible and retrieves its text value.
     */
    public String getText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    /**
     * Waits until the element is clickable, then performs a click action.
     */
    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    /**
     * Waits for the element to be visible, clears existing text, 
     * and types the given input string.
     */
    public void type(By locator, String text) {
        if (text == null) {
            text = "";  // Replace null with empty string
        }
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click(); // Focus the input
        element.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Select all
        element.sendKeys(Keys.BACK_SPACE); // Delete existing value
        element.sendKeys(text); // Type your custom input
    }

    /**
     * Explicitly waits until the element is visible on the page.
     */
    public void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Explicitly waits until the element is clickable on the page.
     */
    public void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    /**
     * Navigates to a specific URL.
     */
    public void navigateTo(String url) {
        driver.get(url);
    }

    /**
     * Returns the current URL of the page.
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Returns the current page title.
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}
