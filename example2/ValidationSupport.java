package example2;

import java.util.Collections;
import java.util.List;

public class ValidationSupport {
    private static final ValidationResult valid = new ValidationResult() {
        public boolean isValid() {
            return true;
        }

        public List<Violation> getViolations() {
            return Collections.emptyList();
        }
    };

    static ValidationResult valid() {
        return valid;
    }
}
