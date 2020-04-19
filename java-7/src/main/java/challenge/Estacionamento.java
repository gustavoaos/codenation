package challenge;

import java.util.LinkedList;
import java.util.List;
// import java.util.PriorityQueue;
// import java.util.Queue;
// import java.util.Comparator;
import java.util.Optional;

public class Estacionamento {

    private final int PARKING_SPACE = 10;
    private final int LEGAL_AGE = 18;
    private final int MAX_DEMERIT_POINTS = 20;
    private final int MIN_PRIORITY_AGE = 55;

    private final List<Carro> parkedCars = new LinkedList<>();
    // private final Queue<Carro> parkedCars = new PriorityQueue<>(this.PARKING_SPACE,
    //         Comparator.comparing(parkedCar -> parkedCar.getMotorista().getIdade()));

    public void estacionar(Carro car) throws EstacionamentoException {
        if (car.getMotorista() == null) {
            throw new EstacionamentoException("Automated cars are not allowed. A driver is required.");
        }
        if (car.getMotorista().getIdade() < this.LEGAL_AGE) {
            throw new EstacionamentoException("The driver must be of legal age.");
        }
        if (car.getMotorista().getPontos() > this.MAX_DEMERIT_POINTS) {
            throw new EstacionamentoException("The driver's license must be valid.");
        }

        if (this.carrosEstacionados() < this.PARKING_SPACE) {
            this.parkedCars.add(car);
        } else {
            Carro firstCarToEnterUnderPriorityAge = this.getFirstCarToEnterUnderPriorityAge();

            this.parkedCars.remove(firstCarToEnterUnderPriorityAge);
            this.parkedCars.add(car);
        }
    }

    public int carrosEstacionados() {
        return this.parkedCars.size();
    }

    public boolean carroEstacionado(Carro car) {
        return this.parkedCars.contains(car);
    }

    private Carro getFirstCarToEnterUnderPriorityAge() throws EstacionamentoException {
		Optional<Carro> result = this.parkedCars.stream()
            .filter(parkedCar -> parkedCar.getMotorista().getIdade() < this.MIN_PRIORITY_AGE)
            .findFirst();

		if (result.isPresent() == false) {
			throw new EstacionamentoException("No parking spaces available.");
		}

		return result.get();
	}
}
