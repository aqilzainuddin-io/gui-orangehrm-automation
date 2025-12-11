package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.BasePage;

public class LoginPage extends BasePage {

    // locator
    private By usernameField = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    private By passwordField = By.xpath("//label[text()='Password']/../following-sibling::div/input");
    private By loginButton = By.xpath("//button[contains(normalize-space(),'Login')]");
    private By invalidCredMsg = By.xpath("//p[contains(normalize-space(),'Invalid credentials')]");
    private By usernameRequiredMsg = By.xpath("//label[text()='Username']/../following-sibling::span[text()='Required']");
    private By passwordRequiredMsg = By.xpath("//label[text()='Password']/../following-sibling::span[text()='Required']");


    // constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // getter method
    public boolean isInvalidCredErrMsgVisible() {
        return isElementDisplayed(invalidCredMsg);
    }
    public String getInvalidCredErrMsg() {
        return getText(invalidCredMsg);
    }
    public boolean isUsernameReqErrMsgVisible(){
        return isElementDisplayed(usernameRequiredMsg);
    }
    public boolean isPasswordReqErrMsgVisible(){
        return isElementDisplayed(passwordRequiredMsg);
    }
    public String getUsernameReqMsg(){
        return getText(usernameRequiredMsg);
    }
    public String getPasswordReqMsg(){
        return getText(passwordRequiredMsg);
    }

    // action method
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

}
