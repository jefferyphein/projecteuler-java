/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */

package projecteuler.app;

import java.util.stream.LongStream;
import java.util.stream.IntStream;

public final class Euler010 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler010().run());
    }

    public String run() {
        return Long.toString(
            IntStream.of(Lib.primesUpTo(2000000))
                     .mapToLong(x -> x)
                     .reduce(0, Long::sum));
    }
}
