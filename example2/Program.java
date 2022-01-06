package example2;

public class Program {
    public static void main(String[] args) {
        var validUser = new User("user", 30, "mail@mailinator.com");
        var invalidUser1 = new User("", 30, "mail@mailinator.com");
        var invalidUser2 = new User("user", 30, "mailmailinator.com");
        var invalidUser3 = new User("", 30, "mailmailinator.com");

        System.out.println("valid");
        validateUser(validUser);

        System.out.println("invalid 1");
        validateUser(invalidUser1);

        System.out.println("invalid 2");
        validateUser(invalidUser2);

        System.out.println("invalid 3");
        validateUser(invalidUser3);
    }

    static void validateUser(User user) {
        UserValidation validation = UserValidation.all(
            UserValidation.nameIsNotEmpty(),
            UserValidation.eMailContainsAtSign()
        );

        ValidationResult result = validation.apply(user);

        result.getViolations().forEach(System.out::println);
    }
}
