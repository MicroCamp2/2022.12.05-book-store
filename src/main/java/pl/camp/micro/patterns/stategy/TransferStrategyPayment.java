package pl.camp.micro.patterns.stategy;

import pl.camp.micro.patterns.Order;


public class TransferStrategyPayment implements PaymentStrategy {
    @Override
    public void execute(Order order) {
        System.out.println("Transfer method pay " + order.calculatePrice());
    }
}