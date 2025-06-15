package bao.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchGenericExceptionExample {
    private static final Logger logger = Logger.getLogger(CatchGenericExceptionExample.class.getName());

    public static void main(String[] args) {
        String s = getString();

        if (s != null) {
            logger.log(Level.INFO, "String length: {0}", s.length());
        } else {
            logger.warning("String is null, cannot get length");
        }
    }

    private static String getString() {
        // Có thể trả null hoặc chuỗi
        return Math.random() > 0.5 ? "Hello" : null;
    }

}
