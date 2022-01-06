package example3;

public class User {

    public final String name;
    public final int age;
    public final String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User [age=" + age + ", email=" + email + ", name=" + name + "]";
    }
}
