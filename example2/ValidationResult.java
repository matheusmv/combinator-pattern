package example2;

import java.util.List;

public interface ValidationResult {
    
    static ValidationResult valid() {
        return ValidationSupport.valid();
    }

    static ValidationResult invalid(List<Violation> violations) {
        return new Invalid(violations);
    }

    boolean isValid();

    List<Violation> getViolations();
}
