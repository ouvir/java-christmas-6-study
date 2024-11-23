package christmas.model.menu;

import christmas.exception.InputException;

import java.util.ArrayList;
import java.util.List;

import static christmas.exception.InputExceptionType.ORDER_FORMAT_ERROR;
import static christmas.model.menu.MenuType.*;

public class MenuList {
    private final List<Menu> menuList = new ArrayList<>();

    public MenuList() {
        addAppetizerMenu();
        addMainMenu();
        addDessertMenu();
        addDrinkMenu();
    }

    public String findMenuType(String menuName) throws InputException {
        for (Menu menu : menuList) {
            if (menu.getName().equals(menuName)) {
                return menu.getMenuType().getType();
            }
        }
        throw new InputException(ORDER_FORMAT_ERROR);
    }
    public int findMenuPrice(String menuName) {
        for (Menu menu : menuList) {
            if (menu.getName().equals(menuName)) {
                return menu.getPrice();
            }
        }
        return 0;
    }

    public Menu findMenu(String menuName) {
        for (Menu menu : menuList) {
            if (menu.getName().equals(menuName)) {
                return menu;
            }
        }
        throw new InputException(ORDER_FORMAT_ERROR);
    }

    private void addAppetizerMenu() {
        menuList.add(new Menu("양송이수프", 6_000, APPETIZER));
        menuList.add(new Menu("타파스", 5_500, APPETIZER));
        menuList.add(new Menu("시저샐러드", 8_000, APPETIZER));
    }

    private void addMainMenu() {
        menuList.add(new Menu("티본스테이크", 55_000, MAIN));
        menuList.add(new Menu("바비큐립", 54_000, MAIN));
        menuList.add(new Menu("해산물파스타", 35_000, MAIN));
        menuList.add(new Menu("크리스마스파스타", 25_000, MAIN));
    }

    private void addDessertMenu() {
        menuList.add(new Menu("초코케이크", 15_000, DESSERT));
        menuList.add(new Menu("아이스크림", 5_000, DESSERT));
    }

    private void addDrinkMenu() {
        menuList.add(new Menu("제로콜라", 3_000, DRINK));
        menuList.add(new Menu("레드와인", 60_000, DRINK));
        menuList.add(new Menu("샴페인", 25_000, DRINK));
    }
}
