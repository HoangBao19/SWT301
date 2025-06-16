import bao.example.InsecureLogin;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsecureLoginTest {

    @Test
    void testLoginSuccess() {
        System.setProperty("ADMIN_PASSWORD", "123456"); // Simulate environment variable
        boolean result = InsecureLogin.login("admin", "123456"); // Assume login returns boolean
        assertTrue(result, "Login should succeed with valid credentials");
    }

    @Test
    void testLoginFail() {
        System.setProperty("ADMIN_PASSWORD", "123456");
        boolean result = InsecureLogin.login("user", "wrongpassword"); // Assume login returns boolean
        assertFalse(result, "Login should fail with wrong password");
    }

    @Test
    void testPrintUserInfo() {
        InsecureLogin insecureLogin = new InsecureLogin();
        // Capture System.out to verify printUserInfo (using ByteArrayOutputStream for JDK 17)
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(outContent));
        insecureLogin.printUserInfo("John Doe");
        System.setOut(originalOut);
        assertTrue(outContent.toString().contains("John Doe"), "Should print user info");
    }
}