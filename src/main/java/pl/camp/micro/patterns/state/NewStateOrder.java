package pl.camp.micro.patterns.state;

import pl.camp.micro.patterns.Order;
import pl.camp.micro.patterns.Position;
import pl.camp.micro.patterns.stategy.PaymentStrategy;

public class NewStateOrder implements OrderState {
    private final Order order;

    public NewStateOrder(Order order) {
        this.order = order;
    }


    @Override
    public void addPosition(Position position) {
        order.getPositions().add(position);
    }
}
