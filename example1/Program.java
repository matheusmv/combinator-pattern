package example1;

public class Program {
    public static void main(String[] args) {
        var validUser = new User("user", 30, "mail@mailinator.com");
        var invalidUser = new User("", 30, "mail@mailinator.com");

        validateUser(validUser);
        validateUser(invalidUser);
    }

    static void validateUser(User user) {
        UserValidation validation = UserValidation.nameIsNotEmpty()
                .and(UserValidation.eMailContainsAtSign());

        ValidationResult result = validation.apply(user);

        result.getReason().ifPresent(System.out::println);
    }
}
