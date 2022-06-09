/*
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1)
 * contains 10 terms. Although it has not been proved yet (Collatz Problem),
 * it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

package projecteuler.app;

import java.util.stream.IntStream;

public final class Euler014 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler014().run());
    }

    public String run() {
        int[] collatz = new int[1000000];
        collatz[1] = 1;

        int answer = 1;
        int value = 1;
        for (int i=2; i<collatz.length; i++) {
            collatz[i] = Lib.collatzWithLookup(i, collatz);
            if (collatz[i] > value) {
                value = collatz[i];
                answer = i;
            }
        }

        return Integer.toString(answer);
    }
}
