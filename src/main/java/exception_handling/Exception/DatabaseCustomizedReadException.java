package exception_handling.Exception;

public class DatabaseCustomizedReadException extends RuntimeException {
    public DatabaseCustomizedReadException(String message) {
        super(message);
    }
}