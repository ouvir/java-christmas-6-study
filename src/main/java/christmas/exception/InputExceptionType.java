package christmas.exception;

public enum InputExceptionType {
    DATE_FORMAT_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요.")
    ;

    private static final String PREFIX = "[ERROR] ";
    private final String message;


    InputExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
