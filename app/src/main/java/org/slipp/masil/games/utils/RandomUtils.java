package org.slipp.masil.games.utils;

import java.util.Random;

public class RandomUtils {
	private static final Random RANDOM = new Random();

	private RandomUtils() {
	}

	public static long nextLong(final int startInclusive, final int endInclusive) {
		if (startInclusive > endInclusive || startInclusive < 0) {
			throw new IllegalArgumentException();
		}
		if (startInclusive == endInclusive) {
			return startInclusive;
		}

		return startInclusive + RANDOM.nextInt(endInclusive - startInclusive + 1);
	}
}
