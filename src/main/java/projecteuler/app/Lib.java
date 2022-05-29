package projecteuler.app;

public class Lib {
    public static boolean isPalindrome(long N) {
        String strN = Long.toString(N);
        return strN.equals(new StringBuilder(strN).reverse().toString());
    }
}
