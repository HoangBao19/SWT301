class AccountServiceTest {
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountService();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    void testRegisterAccount(String username, String password, String email, boolean expected) {
        boolean result = accountService.registerAccount(username, password, email);
        assertEquals(expected, result,
                String.format("Registration failed for username: %s, password: %s, email: %s",
                        username, password, email));
    }

    @Test
    void testIsValidEmail_ValidEmail() {
        assertTrue(accountService.isValidEmail("john@example.com"));
        assertTrue(accountService.isValidEmail("carol@domain.com"));
    }

    @Test
    void testIsValidEmail_InvalidEmail() {
        assertFalse(accountService.isValidEmail("bobmail.com"));
        assertFalse(accountService.isValidEmail(""));
        assertFalse(accountService.isValidEmail(null));
    }

    @Test
    void testRegisterAccount_NullUsername() {
        assertFalse(accountService.registerAccount(null, "password", "test@example.com"));
    }

    @Test
    void testRegisterAccount_ShortPassword() {
        assertFalse(accountService.registerAccount("alice", "short", "alice@mail.com"));
    }

    @Test
    void testRegisterAccount_InvalidEmail() {
        assertFalse(accountService.registerAccount("bob", "password", "bobmail.com"));
    }
}