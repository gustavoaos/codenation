package br.com.codenation.paymentmethods;

public enum PaymentMethod {

    CASH(new PriceStrategyCash()),
    DEBIT_CARD(new PriceStrategyDebitCard()),
    CREDIT_CARD(new PriceStrategyCreditCard()),
    TRANSFER(new PriceStrategyTransfer());

    private PriceStrategy priceStrategy;

    PaymentMethod(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public PriceStrategy getPaymentStrategy() {
        return priceStrategy;
    }
}