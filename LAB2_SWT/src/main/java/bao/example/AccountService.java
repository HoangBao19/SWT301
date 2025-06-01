package bao.example;

public class AccountService {
    public boolean registerAccount(String username, String password, String email) {
        if (username == null || username.isEmpty()) {
            return false;
        }
        if (password == null || password.length() <= 6) {
            return false;
        }
        if (!isValidEmail(email)) {
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        // Basic email regex: requires at least one character before @, @, and a domain with a dot
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email.matches(emailRegex);
    }
}
