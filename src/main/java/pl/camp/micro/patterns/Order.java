package pl.camp.micro.patterns;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Status status;
    private String payMethod;

    public static void main(String[] args) {
        Order order = new Order();
        List<Position> positions = new ArrayList<>();

        Position position1 = new Position();
        position1.setBook(new Book());
        position1.setQuantity(1);

        positions.add(position1);

        Position position2 = new Position();
        position2.setBook(new Book());
        position2.setQuantity(2);

        positions.add(position2);

        position2.setQuantity(3);
        order.payMethod = "BLIK";
        order.setStatus(Status.ACCEPTED);


        Position position3 = new Position();
        position3.setBook(new Book());
        position3.setQuantity(1);

        positions.add(position3);
//        PAY
        if (order.payMethod == "BLIK") {

            System.out.println("Blik method pay" + positions.stream()
                    .map(p -> p.getQuantity() * p.getQuantity())
                    .map(BigDecimal::valueOf)
                    .reduce(BigDecimal.ZERO, (a, b) -> b.add(a)));
        } else {
            System.out.println("Transfer method pay" + positions.stream()
                    .map(p -> p.getQuantity() * p.getQuantity())
                    .map(BigDecimal::valueOf)
                    .reduce(BigDecimal.ZERO, (a, b) -> b.add(a)));
        }


    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
