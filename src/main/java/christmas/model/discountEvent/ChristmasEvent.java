package christmas.model.discountEvent;

import christmas.model.order.Orders;

public class ChristmasEvent implements DiscountEvent {
    private static final int CHRISTMAS_DISCOUNT_START = 1000;
    private static final int CHRISTMAS_DISCOUNT = 100;
    private static final int CHRISTMAS_DAY = 25;
    private static final int START_DAY = 1;

    @Override
    public int discount(Orders orders, int date) {
        if (!isValidEvent(orders, date)) {
            return 0;
        }
        return CHRISTMAS_DISCOUNT_START + CHRISTMAS_DISCOUNT * (date - START_DAY);
    }

    @Override
    public boolean isValidEvent(Orders orders, int date) {
        return date <= CHRISTMAS_DAY;
    }

}
