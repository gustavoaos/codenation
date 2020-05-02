package br.com.codenation.paymentmethods;

public class PriceStrategyDebitCard implements PriceStrategy {

    final private double DISCOUNT = 0.05;

    @Override
    public Double calculate(Double price) {
        return price * (1 - this.DISCOUNT);
    }
    
}