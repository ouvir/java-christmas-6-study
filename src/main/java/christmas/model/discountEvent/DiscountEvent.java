package christmas.model.discountEvent;

import christmas.model.order.Orders;

public interface DiscountEvent {
    int discount(Orders orders, int date);

    boolean isValidEvent(Orders orders, int date);
}
