package pl.camp.micro.patterns;

import lombok.Getter;
import org.springframework.util.Assert;
import pl.camp.micro.patterns.state.AcceptedOrderState;
import pl.camp.micro.patterns.state.NewStateOrder;
import pl.camp.micro.patterns.state.OrderState;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
public class Order {
    private final List<Position> positions = new ArrayList<>();
    OrderState state = new NewStateOrder(this);
    private Status status; //lokalna
    private String payMethod;

    //SOLID
    public static void main(String[] args) {
        Order order = new Order()
                .addPosition(new Book(new BigDecimal("22.50")), 1)
                .addPosition(new Book(new BigDecimal("29.50")), 2);
        order.updateQuantity(2, 3);

        order.payMethod = "BLIK";
        order.setStatus(Status.ACCEPTED);
        order.changeState(new AcceptedOrderState(order));
        order.addPosition(new Book(new BigDecimal("25.50")), 2);

        order.state.pay();

    }

    void changeState(OrderState orderState) {
        state = orderState;
    }

    public void updateQuantity(int position, int quantity) {
        Assert.isTrue(positions.size() >= position && position >= 1, "Nie znaleziono obiektu");
        positions.get(position - 1).setQuantity(quantity);
    }

    public Order addPosition(Book book, int quantity) {
        Position position = Position.builder()
                .book(book)
                .quantity(quantity)
                .build();
        state.addPosition(position);
        return this;
    }

    public BigDecimal calculatePrice() {
        return positions.stream()
                .map(p -> p.getBook().getPrice().multiply(new BigDecimal(p.getQuantity())))
                .reduce(BigDecimal.ZERO, (a, b) -> b.add(a));
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
