package bao.example;

import java.util.logging.Logger;

public class UnreachableCodeExample {
    private static final Logger logger = Logger.getLogger(UnreachableCodeExample.class.getName());

    private static final int NUMBER = 42;  // declare constant

    public static void main(String[] args) {
        logger.info("Number: " + NUMBER);
    }
}
