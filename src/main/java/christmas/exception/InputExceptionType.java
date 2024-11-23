package christmas.exception;

public enum InputExceptionType {
    DATE_FORMAT_ERROR("유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    ORDER_FORMAT_ERROR("유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ORDER_MAX_COUNT_ERROR("메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;


    InputExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX + message;
    }
}
