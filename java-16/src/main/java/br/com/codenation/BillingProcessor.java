package br.com.codenation;

import br.com.codenation.paymentmethods.PriceStrategy;

public class BillingProcessor {

    private PriceStrategy priceStrategy;

    public Double calculate(Order order) {
        this.priceStrategy = order.getPaymentMethod()
                                  .getPaymentStrategy();

        return this.priceStrategy.calculate(order.getPrice());
    }
}