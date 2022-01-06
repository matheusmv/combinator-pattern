package example2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface UserValidation extends Function<User, ValidationResult> {

    static UserValidation nameIsNotEmpty() {
        return holds(user -> !user.name.trim().isEmpty(), new Violation("Name is empty.", Error.INVALID_NAME));
    }

    static UserValidation eMailContainsAtSign() {
        return holds(user -> user.email.contains("@"), new Violation("Missing @-sign.", Error.INVALID_EMAIL));
    }

    static UserValidation holds(Predicate<User> p, Violation violation) {
        return user -> p.test(user) ? ValidationResult.valid() : ValidationResult.invalid(List.of(violation));
    }

    static UserValidation all(UserValidation... validations) {
        return user -> Arrays.stream(validations)
                .map(validation -> validation.apply(user))
                .filter(result -> !result.isValid())
                .collect(Collectors.reducing(
                        ValidationResult.valid(),
                        (a, b) -> {
                            var violations = new ArrayList<>(a.getViolations());
                            violations.addAll(b.getViolations());

                            return new Invalid(violations);
                        }));
    }
}
