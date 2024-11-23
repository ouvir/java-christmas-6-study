package christmas.service;

import christmas.exception.InputException;
import christmas.model.menu.MenuList;
import christmas.model.order.Order;

public class MenuService {
    private static final MenuList menuList = new MenuList();

    public String findMenu(Order order) throws InputException {
        return menuList.findMenuType(order.getName());
    }

    public int getPrice(String name) {
        return menuList.findMenuPrice(name);
    }
}
