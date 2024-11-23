package christmas.service;

import christmas.dto.OrderDTO;
import christmas.exception.InputException;
import christmas.model.Order;
import christmas.model.Orders;
import christmas.utils.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static christmas.exception.InputExceptionType.*;
import static christmas.model.MenuType.*;
import static christmas.utils.Constants.ORDER_MAX_COUNT;

public class OrderService {
    private final MenuService menuService;

    public OrderService(MenuService menuService) {
        this.menuService = menuService;
    }

    public Orders makeOrders(String text) {
        List<Order> orders = makeOrderList(text);
        validateOrders(orders);
        return divideOrder(orders);
    }

    private void validateOrders(List<Order> orders) {
        checkDuplicate(orders);
        checkValidMenu(orders);
        checkTotalMenu(orders);
    }


    private void checkValidMenu(List<Order> orders) throws InputException {
        orders.forEach(menuService::findMenu);
    }

    private void checkDuplicate(List<Order> orders) throws InputException {
        if (orders.stream().map(Order::getName).distinct().count() != orders.size()) {
            throw new InputException(ORDER_FORMAT_ERROR);
        }
    }

    private void checkTotalMenu(List<Order> orders) {
        if (orders.stream().map(Order::getCount).reduce(0, Integer::sum) > ORDER_MAX_COUNT) {
            throw new InputException(ORDER_MAX_COUNT_ERROR);
        }
    }

    private List<Order> makeOrderList(String text) {
        List<Order> orders = new ArrayList<>();
        List<String> splitItem = Parser.split(text);
        splitItem.stream().map(Order::new).forEach(orders::add);
        return orders;
    }

    private Orders divideOrder(List<Order> orders) {
        List<Order> appetizers = new ArrayList<>();
        List<Order> mains = new ArrayList<>();
        List<Order> desserts = new ArrayList<>();
        List<Order> drinks = new ArrayList<>();
        orders.forEach(order -> addMenuForType(appetizers, mains, desserts, drinks, order));
        return new Orders(appetizers, mains, desserts, drinks);
    }

    // 이부분 최적화가 너무 안 좋은 듯.. 라인도 길구
    private void addMenuForType(
            List<Order> appetizers,
            List<Order> mains,
            List<Order> desserts,
            List<Order> drinks,
            Order order
    ) {
        String type = menuService.findMenu(order);
        if (Objects.equals(type, APPETIZER.getType())) {
            appetizers.add(order);
        }
        if (Objects.equals(type, MAIN.getType())) {
            mains.add(order);
        }
        if (Objects.equals(type, DESSERT.getType())) {
            desserts.add(order);
        }
        if (Objects.equals(type, DRINK.getType())) {
            drinks.add(order);
        }
    }


    public List<OrderDTO> getOrderMenu(Orders orders) {
        return orders.getAllMenu().stream().map(Order::convertToDTO).toList();
    }

    public int getTotalPrice(Orders orders) {
        return orders.getAllMenu().stream()
                .map(order -> menuService.getPrice(order.getName()) * order.getCount())
                .reduce(0, Integer::sum);
    }
}
