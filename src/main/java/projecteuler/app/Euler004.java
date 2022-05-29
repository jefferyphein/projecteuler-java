/*
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 */

/*
 * The 6-digit palindrome must be of the form
 *   i*j = a*10^5 + b*10^4 + c*10^3 + c*10^2 + b*10 + a
 * for some 0 <= a,b,c <= 9 with a != 0.
 *
 * In particular, it must be divisible by 11 since a-b+c-c+b-a = 0 iff 11|i*j
 */

package projecteuler.app;

public final class Euler004 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler004().run());
    }

    public String run() {
        int ans = 0;
        for (int i=990; i>=100; i-=11) {
            for (int j=999; j>=i; j--) {
                int ij = i*j;
                if (Lib.isPalindrome(ij) && ij > ans) {
                    ans = ij;
                }
            }
        }

        return Integer.toString(ans);
    }
}
