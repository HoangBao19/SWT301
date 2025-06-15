package bao.example;

import java.util.logging.Logger;

class Animal {
    private static final Logger logger = Logger.getLogger(Animal.class.getName());

    void speak() {
        logger.info("Animal speaks");
    }
}

class Dog extends Animal {
    private static final Logger logger = Logger.getLogger(Dog.class.getName());

    // Không phải override, nên đặt tên rõ ràng
    void dogBark() {
        logger.info("Dog barks");
    }
}
