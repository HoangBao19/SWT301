package bao.example;

import java.util.logging.Logger;

public class NullPointerExample {
    private static final Logger logger = Logger.getLogger(NullPointerExample.class.getName());

    public static void main(String[] args) {
        String text = getText();

        if (text != null && !text.isEmpty()) {
            logger.info("Text is not empty");
        } else {
            logger.info("Text is null or empty");
        }
    }

    private static String getText() {
        // Giả lập có thể trả về null hoặc chuỗi
        return Math.random() > 0.5 ? "Hello" : null;
    }
}

