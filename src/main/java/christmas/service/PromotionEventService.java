package christmas.service;

import christmas.dto.PromotionDTO;
import christmas.model.menu.Menu;
import christmas.model.order.Orders;
import christmas.model.promotionEvent.PromotionEvent;

import java.util.ArrayList;
import java.util.List;

public class PromotionEventService {
    private List<PromotionEvent> promotionEvents = new ArrayList<PromotionEvent>();

    public PromotionEventService(List<PromotionEvent> promotionEvents) {
        this.promotionEvents.addAll(promotionEvents);
    }

    public List<PromotionDTO> applyPromotionEvent(Orders orders, int totalPrice) {
        List<PromotionDTO> dtos = new ArrayList<>();
        for (PromotionEvent promotionEvent : promotionEvents) {
            if (promotionEvent.isValidPromotionEvent(totalPrice)) {
                Menu promotion = promotionEvent.getPromotion();
                int count = promotionEvent.getCount();
                dtos.add(new PromotionDTO(promotion.getName(), count, promotion.getPrice() * count));
            }
        }
        return dtos;
    }
}
