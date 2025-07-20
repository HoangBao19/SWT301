package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By emailField = By.name("email");
    private final By passwordField = By.name("password");
    private final By loginBtn = By.cssSelector("button[type='submit']");
    private final By successMsg = By.id("success-msg");
    private final By errorMsg = By.id("error-msg");

    public void navigate() {
        navigateTo("login.html");
    }

    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginBtn);
    }

    public boolean isLoginSuccess() {
        return isDisplayed(successMsg);
    }

    public boolean isLoginFailed() {
        return isDisplayed(errorMsg);
    }
}