package br.com.codenation.paymentmethods;

public class PriceStrategyCash implements PriceStrategy {

    final private double DISCOUNT = 0.1;

    @Override
    public Double calculate(Double price) {
        return price * (1 - this.DISCOUNT);
    }
}