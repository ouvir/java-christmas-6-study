package christmas.model.order;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> appetizers = new ArrayList<>();
    private final List<Order> mains = new ArrayList<>();
    private final List<Order> desserts = new ArrayList<>();
    private final List<Order> drinks = new ArrayList<>();

    public Orders(List<Order> appetizers, List<Order> mains, List<Order> desserts, List<Order> drinks) {
        this.appetizers.addAll(appetizers);
        this.mains.addAll(mains);
        this.desserts.addAll(desserts);
        this.drinks.addAll(drinks);
    }

    public List<Order> getAllMenu() {
        List<Order> allMenu = new ArrayList<>();
        allMenu.addAll(appetizers);
        allMenu.addAll(mains);
        allMenu.addAll(desserts);
        allMenu.addAll(drinks);
        return allMenu;
    }
}
