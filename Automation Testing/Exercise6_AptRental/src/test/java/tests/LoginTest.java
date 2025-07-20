package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.LoginPage;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    void setup() {
        driver = DriverFactory.createDriver();
        loginPage = new LoginPage(driver);
        loginPage.navigate();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/login-data.csv", numLinesToSkip = 1)
    void testLogin(String email, String password, String expectedResult) {
        loginPage.login(email, password);
        if (expectedResult.equals("success")) {
            assertTrue(loginPage.isLoginSuccess());
        } else {
            assertTrue(loginPage.isLoginFailed());
        }
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
}