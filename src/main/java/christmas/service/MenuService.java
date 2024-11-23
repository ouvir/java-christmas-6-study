package christmas.service;

import christmas.exception.InputException;
import christmas.model.MenuList;
import christmas.model.Order;

public class MenuService {
    private static final MenuList menuList = new MenuList();

    public String findMenu(Order order) throws InputException {
        return menuList.findMenuType(order.getName());
    }
}
