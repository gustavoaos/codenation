package br.com.codenation.paymentmethods;

public class PriceStrategyTransfer implements PriceStrategy {

    final private double DISCOUNT = 0.08;

    @Override
    public Double calculate(Double price) {
        return price * (1 - this.DISCOUNT);
    }
    
}