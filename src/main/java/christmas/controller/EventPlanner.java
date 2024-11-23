package christmas.controller;

import christmas.utils.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;

    public EventPlanner(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
//        0. 환영
        outputView.printGreeting();
//        1. 예상 방문 날짜 입력 받기
        int date = requestDate();
//                - 검증(null, empty, range)
//        2. 주문할 메뉴와 개수 입력 받기
//                - 검증(format, not found, duplicate, total range)
//        3. 주문 메뉴 출력하기
//        4. 할인 전 총 주문 금액 계산 및 출력
//        5. 증정 메뉴 출력
//        6. 혜택 내역 출력
//        7. 총 혜택 금액 출력
//        8. 할인 후 예상 결제 금액 출력
//        9. 12월 이벤트 배지 출력
    }

    private int requestDate() {
        while (true) {
            try {
                String date = inputView.requestDate();
                Validator.validateDate(date);
                return Integer.parseInt(date);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }


}
