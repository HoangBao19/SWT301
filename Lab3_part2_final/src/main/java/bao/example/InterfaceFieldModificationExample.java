package bao.example;
import java.util.logging.Logger;

public class InterfaceFieldModificationExample {
    private static final Logger logger = Logger.getLogger(InterfaceFieldModificationExample.class.getName());

    public static void main(String[] args) {
        logger.info("Max users: " + Constants.MAX_USERS);
    }
}
