package christmas.controller;

import christmas.dto.EventDTO;
import christmas.dto.PromotionDTO;
import christmas.model.menu.Menu;
import christmas.model.order.Orders;
import christmas.model.promotionEvent.PromotionEvent;
import christmas.service.DiscountEventService;
import christmas.service.OrderService;
import christmas.service.PromotionEventService;
import christmas.utils.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static christmas.model.menu.MenuType.DRINK;

public class EventPlanner {
    private final InputView inputView;
    private final OutputView outputView;
    private final OrderService orderService;
    private final PromotionEventService promotionEventService;
    private final DiscountEventService discountEventService;

    public EventPlanner(InputView inputView, OutputView outputView, OrderService orderService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.orderService = orderService;

        List<PromotionEvent> promotionEvents = new ArrayList<>();
        Menu promotion = new Menu("샴페인", 25_000, DRINK);
        promotionEvents.add(new PromotionEvent(promotion, 1, 120_000));
        this.promotionEventService = new PromotionEventService(promotionEvents);
        this.discountEventService = new DiscountEventService();
    }

    public void run() {
        outputView.printGreeting();
        int date = requestDate();
        Orders orders = requestOrder();
        getInfo(date, orders);
    }

    private void getInfo(int date, Orders orders) {
        outputView.printStartPreview();
        outputView.printOrderMenu(orderService.getOrderMenu(orders));
        int totalPrice = orderService.getTotalPrice(orders);
        outputView.printOrderTotalPrice(totalPrice);
        List<PromotionDTO> promotions = promotionEventService.applyPromotionEvent(orders, totalPrice);
        outputView.printPromotionMenu(promotions);
        int promotionDiscount = promotions.stream()
                .map(dto -> dto.getPromotionPrice() * dto.getPromotionCount())
                .reduce(0, Integer::sum);
//        6. 혜택 내역 출력
        List<EventDTO> eventDiscountInfo = discountEventService.applyEvent(orders, date);
        int eventDiscount = eventDiscountInfo.stream().map(EventDTO::getDiscount).reduce(0, Integer::sum);
        outputView.printEvent(eventDiscountInfo);
//        7. 총 혜택 금액 출력
        outputView.printToTalEventPrice(eventDiscount, promotionDiscount);
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
