package pl.camp.micro.patterns.stategy;

import pl.camp.micro.patterns.Order;

public class BlikPaymentStrategy implements PaymentStrategy {
    @Override
    public void execute(Order order) {
        System.out.println("Blik method pay " + order.calculatePrice());
    }
}
