package christmas.model.promotionEvent;

import christmas.model.menu.Menu;

public class PromotionEvent {
    private final Menu promotion;
    private final int count;
    private final int eventPriceLimit;

    public PromotionEvent(Menu promotion, int count, int eventPriceLimit) {
        this.promotion = promotion;
        this.count = count;
        this.eventPriceLimit = eventPriceLimit;
    }

    public Menu getPromotion() {
        return promotion;
    }

    public int getCount() {
        return count;
    }

    public int getEventPriceLimit() {
        return eventPriceLimit;
    }

    public boolean isValidPromotionEvent(int totalPrice) {
        return totalPrice >= eventPriceLimit;
    }
//    할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
}
