package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePasswordPage extends BasePage {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    private final By currentPassword = By.name("current_password");
    private final By newPassword = By.name("new_password");
    private final By confirmPassword = By.name("confirm_password");
    private final By changePasswordBtn = By.xpath("//button[contains(text(),'Change Password')]");
    private final By successMsg = By.id("change-success");
    private final By errorMsg = By.id("change-error");

    public void navigate() {
        navigateTo("change-password.html");
    }

    public void changePassword(String current, String newPass, String confirmPass) {
        type(currentPassword, current);
        type(newPassword, newPass);
        type(confirmPassword, confirmPass);
        click(changePasswordBtn);
    }

    public boolean isChangeSuccess() {
        return isDisplayed(successMsg);
    }

    public boolean isChangeFailed() {
        return isDisplayed(errorMsg);
    }
}
