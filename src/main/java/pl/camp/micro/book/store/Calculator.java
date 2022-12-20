package pl.camp.micro.book.store;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Calculator {

    public Calculator() {

        log.debug("Konstruktor kalkulatora !!!");
    }

    public int add(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("B can not be 0");
        }
        return ((double) a) / ((double) b);
    }
}
