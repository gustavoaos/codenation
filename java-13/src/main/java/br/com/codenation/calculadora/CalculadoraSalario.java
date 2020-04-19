package br.com.codenation.calculadora;

public class CalculadoraSalario {

	final static Double MINIMUM_WAGE = 1039.0D;

	public long calcularSalarioLiquido(double salarioBase) {
		Double liquidSalary = salarioBase;

		if (this.isLessThanMinimumWage(salarioBase)) {
			liquidSalary = 0.0;
		} else {
			liquidSalary = this.computeINSS(liquidSalary);
			liquidSalary = this.computeIRRF(liquidSalary);
		}
		
		return Math.round(liquidSalary);
	}

	private Boolean isLessThanMinimumWage(double baseSalary) {
		return baseSalary < CalculadoraSalario.MINIMUM_WAGE;
	}
	
	private double computeINSS(double salarioBase) {
		Double salary = salarioBase;

		if (salarioBase > 4000) {
			salary = salarioBase * (1 - 0.11);
		} else if (salarioBase > 1500) {
			salary = salarioBase * (1 - 0.09);
		} else {
			salary = salarioBase * (1 - 0.08);
		}

		return salary;
	}
	
	private double computeIRRF(double salarioBase) {
		Double salary = salarioBase;

		if (salarioBase > 6000) {
			salary = salarioBase * (1 - 0.15);
		} else if (salarioBase > 3000) {
			salary = salarioBase * (1 - 0.075);
		}

		return salary;
	}

}