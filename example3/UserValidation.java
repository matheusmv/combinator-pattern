package example3;

import java.util.function.Function;

public interface UserValidation extends Function<User, Boolean> {

    static UserValidation nameIsNotEmpty() {
        return user -> !user.name.trim().isEmpty();
    }

    static UserValidation isOver18YearsOld() {
        return user -> user.age >= 18;
    }

    static UserValidation eMailContainsAtSign() {
        return user -> user.email.contains("@");
    }

    default UserValidation and(UserValidation other) {
        return user -> this.apply(user) && other.apply(user);
    }
}
