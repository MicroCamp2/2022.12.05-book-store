package pl.camp.micro.patterns.stategy;

import lombok.extern.slf4j.Slf4j;
import pl.camp.micro.patterns.Order;


@Slf4j
public class TransferStrategyPayment implements PaymentStrategy {
    @Override
    public void execute(Order order) {
        log.debug("Transfer method pay " + order.calculatePrice());
    }
}