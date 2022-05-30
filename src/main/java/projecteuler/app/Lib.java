package projecteuler.app;

import java.util.Vector;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.stream.IntStream;

public class Lib {
    public static boolean isPalindrome(long N) {
        String strN = Long.toString(N);
        return strN.equals(new StringBuilder(strN).reverse().toString());
    }

    public static Vector<String> readLines(String filename) {
        Vector<String> lines = new Vector<String>();

        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(s -> lines.addElement(s));
        }
        catch (IOException e) {
            return null;
        }

        return lines;
    }

    public static int[] primesUpTo(int upto) {
        // No primes less than 2.
        if (upto < 2) {
            return new int[0];
        }

        // We will only sieve odd primes starting with 3.
        int size = (upto-1)/2;
        int[] sieve = IntStream.range(0, size).toArray();

        // Remove all odd multiples of 3.
        for (int j=3; j<size; j+=3) {
            sieve[j] = -1;
        }

        // Set up the prime wheel to more efficiently sieve the primes.
        // The wheel generates a sequence of odd integers
        //      5, 7, 11, 13, 17, 19, 23, 25, 29, 31, 35, 37, 41, ...
        // Note that this sequence generates numbers which are 1,-1 mod 6,
        // as these are the only residual values primes >= 5 may have, since
        // 3 mod 6 is obviously composite.
        int wheel = 1;
        int index = 1;
        int p = 5;

        // This is as far as we need to sieve.
        int upper = (int)Math.floor(Math.sqrt(upto));

        while (p <= upper) {
            if (sieve[index] >= 0) {
                for (int k=index+p; k<size; k+=p) {
                    sieve[k] = -1;
                }
            }

            p += 2*wheel;
            index += wheel;
            wheel = 3-wheel;
        }

        // Convert compressed sieve into list of primes.
        return IntStream.concat(
            IntStream.of(2),    // Don't forget that 2 is prime.
            IntStream.of(sieve)
                     .filter(x -> x >= 0)       // Remove non-primes.
                     .map(x -> 2*x+3)           // Convert index to prime.
        ).toArray();
    }
}
