package challenge;

import java.util.Objects;

public class Motorista {

    private final String name;
    private final int age;
    private final int demeritPoints;
    private final String driversLicense;

    private Motorista(String name, int age, int demeritPoints, String driversLicense) {
        this.name = name;
        this.age = age;
        this.demeritPoints = demeritPoints;
        this.driversLicense = driversLicense;
    }

    public String getNome() {
        return name;
    }

    public int getIdade() {
        return age;
    }

    public int getPontos() {
        return demeritPoints;
    }

    public String getHabilitacao() {
        return driversLicense;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Motorista motorista = (Motorista) o;
        return Objects.equals(driversLicense, motorista.driversLicense);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(driversLicense);
    }

    @Override
    public String toString() {
        return "Motorista{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", demeritPoints=" + demeritPoints +
                ", driversLicense='" + driversLicense + '\'' +
                '}';
    }

    public static MotoristaBuilder builder() {
        return new MotoristaBuilder();
    }


    public static class MotoristaBuilder {

        private String name;
        private int age;
        private int demeritPoints;
        private String driversLicense;

        private MotoristaBuilder() {
        }

        public MotoristaBuilder withNome(String name) {
            this.name = name;
            return this;
        }

        public MotoristaBuilder withIdade(int age) throws IllegalArgumentException {
            if (age <= 0) {
                throw new IllegalArgumentException();
            }

            this.age = age;
            return this;
        }

        public MotoristaBuilder withPontos(int demeritPoints) throws IllegalArgumentException {
            if (demeritPoints <= 0) {
                throw new IllegalArgumentException();
            }

            this.demeritPoints = demeritPoints;
            return this;
        }

        public MotoristaBuilder withHabilitacao(String driversLicense) {
            this.driversLicense = driversLicense;
            return this;
        }


        public Motorista build() throws NullPointerException {
            if (name == null || driversLicense == null) {
                throw new NullPointerException();
            }
            
            return new Motorista(name, age, demeritPoints, driversLicense);
        }
    }
}
