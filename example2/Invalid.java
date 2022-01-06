package example2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Invalid implements ValidationResult {
    
    private final List<Violation> violations;

    public Invalid(List<Violation> violations) {
        this.violations = new ArrayList<>(violations);
    }

    public boolean isValid() {
        return false;
    }

    public List<Violation> getViolations() {
        return Collections.unmodifiableList(violations);
    }
}
