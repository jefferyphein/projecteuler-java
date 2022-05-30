/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 * a**2 + b**2 = c**2
 *
 * For example, 3**2 + 4**2 = 9 + 16 = 25 = 5**2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

/*
 * Let c = 1000 - a - b.
 * Then, a**2 + b**2 = 1000000 + a**2 + b**2 - 2000*a - 2000*b + 2*a*b
 * So, 2000*(a + b) = 1000000 + 2*a*b
 *  => a + b = 500 + a*b/1000
 *  => a - a*b/1000 = 500 - b
 *  => a * (1 - b/1000) = 500 - b
 *  => a * (1000 - b) = 1000*(500 - b)
 *  => a = 1000*(500 - b) / (1000 - b)
 *
 * In particular, this means that 1000-b must divide 1000*(500-b).
 *
 * We may also assume WLOG that a <= b, therefore b >= 1000*(500 - b) / (1000 - b)
 *  =>  (1000 - b) * b >= 500000 - 1000*b
 *  =>  1000*b - b**2 >= 500000 - 1000*b
 *  =>  0 >= b**2 - 2000*b + 500000
 *
 * This is true whenever b >= 293.
 */

package projecteuler.app;

public final class Euler009 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler009().run());
    }

    public String run() {
        for (int b=293; b<=1000; b++) {
            if ((1000*(500 - b)) % (1000 - b) == 0) {
                int a = 1000*(500 - b)/(1000 - b);
                int c = 1000 - a - b;
                return Integer.toString(a*b*c);
            }
        }
        return null;
    }
}
