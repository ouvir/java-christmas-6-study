package christmas.service;

import christmas.dto.EventDTO;
import christmas.model.order.Orders;
import christmas.model.discountEvent.*;

import java.util.ArrayList;
import java.util.List;

public class DiscountEventService {
    private final List<DiscountEvent> discountEvents = new ArrayList<>();

    public DiscountEventService() {
        discountEvents.add(new ChristmasEvent());
        discountEvents.add(new WeekendEvent());
        discountEvents.add(new WeekdaysEvent());
        discountEvents.add(new StarEvent());
    }

    public List<EventDTO> applyEvent(Orders orders, int date) {
        List<EventDTO> events = new ArrayList<>();
        // 이벤트를 순회하며, 할인 금액과 내역을 담은 정보를 DTO에 담아 반환
        return events;
    }
}
