package christmas.model.order;

import christmas.dto.OrderDTO;
import christmas.utils.Parser;

import java.util.List;

public class Order {
    private static final int NAME_IDX = 0;
    private static final int COUNT_IDX = 1;
    private final String name;
    private int count;

    public Order(String input) {
        List<String> itemInfo = Parser.parse(input);
        this.name = itemInfo.get(NAME_IDX);
        this.count = Integer.parseInt(itemInfo.get(COUNT_IDX));
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public OrderDTO convertToDTO() {
        return new OrderDTO(name, count);
    }
}
