package pl.camp.micro.patterns.stategy;

import lombok.extern.slf4j.Slf4j;
import pl.camp.micro.patterns.Order;

@Slf4j
public class BlikPaymentStrategy implements PaymentStrategy {
    @Override
    public void execute(Order order) {
        log.debug("Blik method pay " + order.calculatePrice());
    }
}
