package christmas;

import christmas.controller.EventPlanner;
import christmas.service.MenuService;
import christmas.service.OrderService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        EventPlanner eventPlanner = new EventPlanner(
                new InputView(),
                new OutputView(),
                new OrderService(new MenuService()));
        eventPlanner.run();
    }
}
