package christmas.model.discountEvent;

import christmas.model.order.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChristmasEventTest {

    @Test
    @DisplayName("크리스마스 할인 테스트")
    void test() {
        ChristmasEvent event = new ChristmasEvent();
        assertEquals(event.discount((Orders) new Object(), 25), 3400);
    }

}