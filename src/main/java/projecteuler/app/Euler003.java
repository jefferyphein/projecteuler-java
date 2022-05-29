/*
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */

package projecteuler.app;

public final class Euler003 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler003().run());
    }

    public String run() {
        long N = 600851475143L;
        double sqrtN = Math.sqrt(N);
        long upper = (long)Math.floor(sqrtN);

        for (long p=3; p<=upper; p+=2) {
            if (N % p == 0) {
                N /= p;
                while (N % p == 0) {
                    N /= p;
                }
                sqrtN = Math.sqrt(N);
                upper = (long)Math.floor(sqrtN);
            }
        }

        return Long.toString(N);
    }
}
