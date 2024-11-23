package christmas.model.discountEvent;

import christmas.model.order.Orders;

public class StarEvent implements DiscountEvent {

    @Override
    public int discount(Orders orders, int date) {
        return 0;
    }

    @Override
    public boolean isValidEvent(Orders orders, int date) {
        return false;
    }
}
