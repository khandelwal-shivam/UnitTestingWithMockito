package exception_handling.Exception;

public class DatabaseCustomizedWriteException extends RuntimeException{
    public DatabaseCustomizedWriteException(String message){
        super(message);
    }
}
