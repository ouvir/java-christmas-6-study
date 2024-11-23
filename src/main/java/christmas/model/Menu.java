package christmas.model;

public class Menu {
    private final String name;
    private final int price;
    private final MenuType type;

    public Menu(String name, int price, MenuType type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public MenuType getMenuType() {
        return type;
    }
}
