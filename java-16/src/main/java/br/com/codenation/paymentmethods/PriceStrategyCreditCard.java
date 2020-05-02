package br.com.codenation.paymentmethods;

public class PriceStrategyCreditCard implements PriceStrategy {

    final private double DISCOUNT = 0.02;

    @Override
    public Double calculate(Double price) {
        return price * (1 - this.DISCOUNT);
    }
    
}