/*
 * Work out the first ten digits of the sum of the following one-hundred
 * 50-digit numbers.
 *
 * ...
 */

package projecteuler.app;

import java.util.stream.Stream;
import java.math.BigInteger;

public final class Euler013 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler013().run());
    }

    public String run() {
        String[] lines = Lib.readLines("data/013/input");
        BigInteger total = Stream.of(lines)
              .map(line -> new BigInteger(line))
              .reduce(new BigInteger("0"), (a, b) -> a.add(b));

        BigInteger pow10 = new BigInteger("10000000000");
        while (total.compareTo(pow10) >= 0) {
            total = total.divide(BigInteger.TEN);
        }
        return total.toString(10);
    }
}
