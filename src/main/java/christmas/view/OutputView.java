package christmas.view;

public class OutputView {
    private static final String GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";

    public void printGreeting() {
        System.out.println(GREETING_MESSAGE);
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
