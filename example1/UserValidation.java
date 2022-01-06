package example1;

import java.util.function.Function;
import java.util.function.Predicate;

public interface UserValidation extends Function<User, ValidationResult> {

    static UserValidation nameIsNotEmpty() {
        return holds(user -> !user.name.trim().isEmpty(), "Name is empty.");
    }

    static UserValidation eMailContainsAtSign() {
        return holds(user -> user.email.contains("@"), "Missing @-sign.");
    }

    static UserValidation holds(Predicate<User> p, String message) {
        return user -> p.test(user) ? ValidationResult.valid() : ValidationResult.invalid(message);
    }

    default UserValidation and(UserValidation validation) {
        return user -> {
            final ValidationResult result = this.apply(user);
            return result.isValid() ? validation.apply(user) : result;
        };
    }
}
