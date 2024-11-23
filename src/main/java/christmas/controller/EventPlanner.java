package christmas.controller;

import christmas.model.Order;
import christmas.model.Orders;
import christmas.service.OrderService;
import christmas.utils.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;
import java.util.List;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;
    private final OrderService orderService;

    public EventPlanner(InputView inputView, OutputView outputView, OrderService orderService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderService = orderService;
    }

    public void run() {
        outputView.printGreeting();
        int date = requestDate();
//        2. 주문할 메뉴와 개수 입력 받기
        Orders orders = requestOrder();
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


    private Orders requestOrder() {
        while (true) {
            try {
                String text = inputView.requestOrder();
                Validator.validateOrder(text);
                return orderService.makeOrders(text);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
