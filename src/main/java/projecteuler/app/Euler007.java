/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */

/*
 * The prime number theorem says that there are 10001 primes less than 116684
 * and so we'll round up to 120000 and do a sieve of Eratosthenes to find all
 * primes up to 120000, then find the 10001st prime from there.
 */

package projecteuler.app;

import java.util.stream.IntStream;

public final class Euler007 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler007().run());
    }

    public String run() {
        int N = 120000;
        int sqrtN = (int)Math.floor(Math.sqrt(N));

        int[] sieve = IntStream.range(0, N).toArray();
        sieve[1] = 0;   // 1 is not prime.

        for (int p=2; p<=sqrtN; p++) {
            if (p == 0) continue;   // Not a prime.

            // Flag all multiples of p as composite.
            for (int i=2*p; i<N; i+=p) {
                sieve[i] = 0;
            }
        }

        // Collect all primes into an array and return the 10001st prime.
        int[] primes = IntStream.of(sieve)
                                .filter(p -> (p > 0))
                                .toArray();
        return Integer.toString(primes[10001]);
    }
}
