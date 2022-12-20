package pl.camp.micro.patterns.state;

import lombok.extern.slf4j.Slf4j;
import pl.camp.micro.patterns.Order;
import pl.camp.micro.patterns.Position;
import pl.camp.micro.patterns.stategy.BlikPaymentStrategy;
import pl.camp.micro.patterns.stategy.StrategyContext;
import pl.camp.micro.patterns.stategy.TransferStrategyPayment;

import java.util.Map;

@Slf4j
public class AcceptedOrderState implements OrderState {

    private final Order order;

    public AcceptedOrderState(Order order) {
        this.order = order;
    }

    @Override
    public void pay() {
        new StrategyContext(
                Map.of("BLIK", new BlikPaymentStrategy(),
                        "TRANSFER", new TransferStrategyPayment())
        ).chooseAndExecute(order);
    }

    @Override
    public void addPosition(Position position) {
        log.warn("Add position {}", position);
    }
}
