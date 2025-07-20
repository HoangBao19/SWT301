package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.ChangePasswordPage;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class ChangePasswordTest {
    WebDriver driver;
    ChangePasswordPage changePage;

    @BeforeEach
    void setup() {
        driver = DriverFactory.createDriver();
        changePage = new ChangePasswordPage(driver);
        changePage.navigate();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/change-password-data.csv", numLinesToSkip = 1)
    void testChangePassword(String currentPass, String newPass, String confirmPass, String expectedResult) {
        changePage.changePassword(currentPass, newPass, confirmPass);

        if (expectedResult.equals("success")) {
            assertTrue(changePage.isChangeSuccess());
        } else {
            assertTrue(changePage.isChangeFailed());
        }
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}
