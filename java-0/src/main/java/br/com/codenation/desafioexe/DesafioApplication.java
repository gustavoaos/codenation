package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	static final int UPPER_FIBONACCI_LIMIT = 350;

	public static List<Integer> fibonacci() {
		List<Integer> fibonacciList = new ArrayList<Integer>();
		
		// Initialize fibonacii list
		fibonacciList.add(0); // Fibonacci first element
		fibonacciList.add(1); // Fibonacci second element

		while (fibonacciList.size() > 1 && 
			fibonacciList.get(fibonacciList.size() - 2) + fibonacciList.get(fibonacciList.size() - 1) < UPPER_FIBONACCI_LIMIT) {
			
			int lastFibonacciValue = fibonacciList.get(fibonacciList.size() - 1);
			int penultimateFibonacciValue = fibonacciList.get(fibonacciList.size() - 2);

			fibonacciList.add(penultimateFibonacciValue + lastFibonacciValue);
		}
		
		return fibonacciList;
	}

	public static Boolean isFibonacci(Integer number) {
		List<Integer> fibonacciList = DesafioApplication.fibonacci();

		return fibonacciList.contains(number);
	}

}