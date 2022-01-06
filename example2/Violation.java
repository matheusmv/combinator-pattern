package example2;

public class Violation {

    private final String errorMessage;
    private final Error error;

    public Violation(String errorMessage, Error error) {
        this.errorMessage = errorMessage;
        this.error = error;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Error getError() {
        return error;
    }

    public static Violation of(String errorMessage, Error error) {
        return new Violation(errorMessage, error);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((error == null) ? 0 : error.hashCode());
        result = prime * result + ((errorMessage == null) ? 0 : errorMessage.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Violation other = (Violation) obj;
        if (error != other.error)
            return false;
        if (errorMessage == null) {
            if (other.errorMessage != null)
                return false;
        } else if (!errorMessage.equals(other.errorMessage))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Violation [error=" + error + ", errorMessage=" + errorMessage + "]";
    }
}
