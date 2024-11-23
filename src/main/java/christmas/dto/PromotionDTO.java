package christmas.dto;

public class PromotionDTO {
    private final String promotionName;
    private final int promotionCount;
    private final int promotionPrice;


    public PromotionDTO(String promotionName, int promotionCount, int promotionPrice) {
        this.promotionName = promotionName;
        this.promotionCount = promotionCount;
        this.promotionPrice = promotionPrice;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public int getPromotionCount() {
        return promotionCount;
    }

    public int getPromotionPrice() {
        return promotionPrice;
    }
}
