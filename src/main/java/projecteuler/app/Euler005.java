/*
 * 2520 is the smallest number that can be divided by each of the numbers from
 * 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 */

/*
 * The answer is the LCM(1,2,3,4,5,...,20) = 2^4*3^3*5*7*11*13*17*19
 *                                         = 232792560
 */

package projecteuler.app;

public final class Euler005 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler005().run());
    }

    public String run() {
        // Solved analytically above.
        return "232792560";
    }
}
