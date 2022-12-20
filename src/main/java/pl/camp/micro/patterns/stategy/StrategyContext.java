package pl.camp.micro.patterns.stategy;

import pl.camp.micro.patterns.Order;

import java.util.Map;

public class StrategyContext {
    private final Map<String, PaymentStrategy> strategyMap;

    public StrategyContext(Map<String, PaymentStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public void chooseAndExecute(Order order) {
        if (strategyMap.containsKey(order.getPayMethod())) {
             strategyMap.get(order.getPayMethod())
                     .execute(order);
             return;
        }
        throw new WrongPaymentMethod(order.getPayMethod());
    }
}
