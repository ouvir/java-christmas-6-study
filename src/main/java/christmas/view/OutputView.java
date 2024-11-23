package christmas.view;

import christmas.dto.EventDTO;
import christmas.dto.OrderDTO;
import christmas.dto.PromotionDTO;

import java.util.List;

public class OutputView {
    private static final String ENTER = "\n";
    private static final String GREETING_MESSAGE = "안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.";
    private static final String START_PREVIEW_MESSAGE = "12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!";
    private static final String MENU_MESSAGE = "<주문 메뉴>";
    private static final String MENU_FORMAT = "%s %d개";
    private static final String BEFORE_DISCOUNT_TOTAL_PRICE_MESSAGE = "<할인 전 총주문 금액>";
    private static final String PRICE_FORMAT = "%,d원";
    private static final String PROMOTION_MENU_MESSAGE = "<증정 메뉴>";
    private static final String NO_MESSAGE = "없음";

    public void printGreeting() {
        System.out.println(GREETING_MESSAGE);
    }

    public void printEnter() {
        System.out.println();
    }

    public void printStartPreview() {
        System.out.println(START_PREVIEW_MESSAGE);
        printEnter();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    public void printOrderMenu(List<OrderDTO> orders) {
        System.out.println(MENU_MESSAGE);
        for (OrderDTO order : orders) {
            System.out.printf(MENU_FORMAT + ENTER, order.getName(), order.getCount());
        }
        printEnter();
    }

    public void printOrderTotalPrice(int totalPrice) {
        System.out.println(BEFORE_DISCOUNT_TOTAL_PRICE_MESSAGE);
        System.out.printf(PRICE_FORMAT + ENTER, totalPrice);
        printEnter();
    }

    public void printPromotionMenu(List<PromotionDTO> promotionDTOS) {
        System.out.println(PROMOTION_MENU_MESSAGE);
        printPromotion(promotionDTOS);
    }

    private void printPromotion(List<PromotionDTO> promotionDTOS) {
        if (promotionDTOS.isEmpty()) {
            printNo();
            return;
        }
        promotionDTOS.forEach(dto -> {
            System.out.printf(MENU_FORMAT + ENTER, dto.getPromotionName(), dto.getPromotionCount());
        });
        printEnter();
    }

    private void printNo() {
        System.out.println(NO_MESSAGE);
        printEnter();
    }

    public void printEvent(List<EventDTO> eventDTOS) {
        // 이벤트 할인 정보 출력
    }

    public void printToTalEventPrice(int eventDiscount, int promotionDiscount) {
        // 총 할인 정보 출력
    }

    public void printExpectedPayment(int expectedPayment) {
        // 결제 예상 금액 출력
    }

    public void printBadge(int eventDiscount) {
        // 뱃지 출력
    }
}
