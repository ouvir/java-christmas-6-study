package christmas.dto;

public class OrderDTO {
    private final String name;
    private final Integer count;

    public OrderDTO(String name, Integer count) {
        this.name = name;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }
}
