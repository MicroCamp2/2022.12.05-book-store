package pl.camp.micro.patterns.state;

import pl.camp.micro.patterns.Position;

public interface OrderState {
    default void pay() {
    }

    default void addPosition(Position position) {
    }
}
