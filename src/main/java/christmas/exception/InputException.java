package christmas.exception;

public class InputException extends IllegalArgumentException {
    public InputException(InputExceptionType exceptionType) {
        super(exceptionType.getMessage());
    }
}
