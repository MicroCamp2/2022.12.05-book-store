package pl.camp.micro.book.store;

public class Calculator {

    public Calculator() {
        System.out.println("Konstruktor kalkulatora !!!");
    }

    public int add(int a, int b) {
        return a+b;
    }

    public double divide(int a, int b) {
        if(b == 0) {
            throw new IllegalArgumentException("B can not be 0");
        }
        return ((double) a) / ((double) b);
    }
}
