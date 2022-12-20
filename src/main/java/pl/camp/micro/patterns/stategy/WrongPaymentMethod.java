package pl.camp.micro.patterns.stategy;

public class WrongPaymentMethod extends RuntimeException {
    public WrongPaymentMethod(String paymentMethod) {
        super("Wrong payment method " + paymentMethod);
    }
}
