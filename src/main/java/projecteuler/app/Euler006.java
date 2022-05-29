/*
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1**2 + 2**2 + ... + 10**2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 *
 * (1+2+...+10)**2 = 55**2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3085-385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 */

package projecteuler.app;

import java.util.stream.IntStream;

public final class Euler006 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler006().run());
    }

    public String run() {
        int sum_squares = IntStream.range(1,101)
                                   .map((n) -> { return n*n; })
                                   .reduce(0, Integer::sum);

        int sum = IntStream.range(1,101)
                           .reduce(0, Integer::sum);

        return Integer.toString( sum*sum - sum_squares );
    }
}
