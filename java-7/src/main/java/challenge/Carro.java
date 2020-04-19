package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista driver;
    private final String licensePlate;
    private final Cor color;

    private Carro(Motorista driver, String licensePlate, Cor color) {
        this.driver = driver;
        this.licensePlate = licensePlate;
        this.color = color;
    }

    public Motorista getMotorista() {
        return driver;
    }

    public String getPlaca() {
        return licensePlate;
    }

    public Cor getCor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(driver, carro.driver) &&
                Objects.equals(licensePlate, carro.licensePlate) &&
                color == carro.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, licensePlate, color);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "driver=" + driver +
                ", licensePlate='" + licensePlate + '\'' +
                ", color=" + color +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista driver;
        private String licensePlate;
        private Cor color;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista driver) {
            this.driver = driver;
            return this;
        }

        public CarroBuilder withPlaca(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public CarroBuilder withCor(Cor color) {
            this.color = color;
            return this;
        }

        public Carro build() throws NullPointerException {
            if (licensePlate == null || color == null) {
                throw new NullPointerException();
            }

            return new Carro(driver, licensePlate, color);
        }
    }
}
