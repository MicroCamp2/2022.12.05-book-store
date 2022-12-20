package pl.camp.micro.patterns.stategy;

import pl.camp.micro.patterns.Order;

public interface PaymentStrategy {
    void execute(Order order);
}
