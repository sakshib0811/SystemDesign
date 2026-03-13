package RateLimiter.Exception;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException(String e) {
        super(e);
    }
}
