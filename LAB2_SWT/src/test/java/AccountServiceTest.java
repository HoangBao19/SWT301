import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import bao.example.AccountService;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @Test
    @DisplayName("isValidEmail returns true for valid email")
    void testValidEmail() {
        assertTrue(accountService.isValidEmail("john@example.com"));
        assertTrue(accountService.isValidEmail("alice123@domain.co.uk"));
    }

    @Test
    @DisplayName("isValidEmail returns false for invalid email")
    void testInvalidEmail() {
        assertFalse(accountService.isValidEmail("invalid.email"));
        assertFalse(accountService.isValidEmail("no@domain"));
        assertFalse(accountService.isValidEmail(""));
        assertFalse(accountService.isValidEmail(null));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    @DisplayName("registerAccount with CSV data")
    void testRegisterAccountWithCsv(String username, String password, String email, boolean expected) {
        boolean result = accountService.registerAccount(username, password, email);
        assertEquals(expected, result,
                String.format("Registration should %s for username=%s, password=%s, email=%s",
                        expected ? "succeed" : "fail", username, password, email));
    }

    @Test
    @DisplayName("registerAccount fails for null username")
    void testRegisterAccountNullUsername() {
        assertFalse(accountService.registerAccount(null, "password123", "test@example.com"));
    }

    @Test
    @DisplayName("registerAccount fails for empty username")
    void testRegisterAccountEmptyUsername() {
        assertFalse(accountService.registerAccount("", "password123", "test@example.com"));
    }

    @Test
    @DisplayName("registerAccount fails for short password")
    void testRegisterAccountShortPassword() {
        assertFalse(accountService.registerAccount("testuser", "short", "test@example.com"));
    }

    @Test
    @DisplayName("registerAccount fails for null password")
    void testRegisterAccountNullPassword() {
        assertFalse(accountService.registerAccount("testuser", null, "test@example.com"));
    }

    @Test
    @DisplayName("registerAccount fails for invalid email")
    void testRegisterAccountInvalidEmail() {
        assertFalse(accountService.registerAccount("testuser", "password123", "invalid.email"));
    }
}