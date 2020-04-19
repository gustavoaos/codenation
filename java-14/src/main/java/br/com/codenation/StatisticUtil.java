package br.com.codenation;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		return Arrays.stream(elements).reduce(0, Integer::sum) / elements.length;
	}

	public static int mode(int[] elements) {
		Map<Integer, Long> counts = Arrays.stream(elements).boxed()
				.collect(Collectors.groupingBy(elem -> elem, Collectors.counting()));

		return counts.entrySet().stream()
				.max(Comparator.comparing(Map.Entry::getValue))
				.get()
				.getKey();
	}

	public static int median(int[] elements) {
		int[] sortedElements = Arrays.stream(elements).sorted().toArray();
		int median = 0;

		if (sortedElements.length % 2 == 0) {
			int centerIndex = sortedElements.length / 2;
			median = (sortedElements[centerIndex - 1] + sortedElements[centerIndex]) / 2;
		} else {
			int centerIndex = (int) Math.floor(sortedElements.length / 2);
			median = sortedElements[centerIndex];
		}

		return median;
	}
}