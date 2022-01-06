package example3;

import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        var users = List.of(
                new User("user1", 30, "mail@mailinator.com"),
                new User("user2", 15, "mail@mailinator.com"),
                new User("", 30, "mail@mailinator.com"),
                new User("user4", 15, "mailmailinator.com"),
                new User("user5", 19, "mail@mailinator.com"));

        users.stream().parallel()
                .filter(UserValidation.nameIsNotEmpty()
                        .and(UserValidation.isOver18YearsOld())
                        .and(UserValidation.eMailContainsAtSign())::apply)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
