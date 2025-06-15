package bao.example;
import java.util.logging.Logger;
class User {
    private static final Logger logger = Logger.getLogger(User.class.getName());
    private String name;
    private int age;
    // Constructor
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // Getter & Setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age >= 0) {  // ví dụ kiểm tra giá trị hợp lệ
            this.age = age;
        }
    }
    public void display() {
        logger.log(java.util.logging.Level.INFO, "Name: {0}, Age: {1}", new Object[]{name, age});

    }
}

