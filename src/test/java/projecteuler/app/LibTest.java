package projecteuler.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Project Euler library functions.
 */
public class LibTest {
    @Test
    public void testIsPalindrome() {
        assertTrue(Lib.isPalindrome(101));
        assertFalse(Lib.isPalindrome(400));
    }

    @Test
    public void testReadLinesFileExists() {
        String[] lines = Lib.readLines("./data/008/input");
        assertEquals(20, lines.length);
    }

    @Test
    public void testReadLinesFileDoesNotExist() {
        String[] lines = Lib.readLines("./data/does_not_exist");
        assertEquals(null, lines);
    }

    @Test
    public void testMaxAdjacentProductEmpty() {
        int[] numbers = {};
        assertEquals(1, Lib.maxAdjacentProduct(numbers, 1));
    }

    @Test
    public void testMaxAdjacentProductShort() {
        int[] numbers = {2};
        assertEquals(2, Lib.maxAdjacentProduct(numbers, 10));
    }

    @Test
    public void textMaxAdjacentProductLong() {
        int[] numbers = {5,10,4,8,12,13,17,1,0};
        assertEquals(17, Lib.maxAdjacentProduct(numbers, 1));
        assertEquals(13*17, Lib.maxAdjacentProduct(numbers, 2));
        assertEquals(12*13*17, Lib.maxAdjacentProduct(numbers, 3));
        assertEquals(8*12*13*17, Lib.maxAdjacentProduct(numbers, 4));
        assertEquals(0, Lib.maxAdjacentProduct(numbers, 25));
    }

    @Test
    public void testPrimesUpToEmpty() {
        int[] primes = Lib.primesUpTo(1);
        assertEquals(0, primes.length);
    }

    @Test
    public void testPrimesUpToTwo() {
        int[] primes = Lib.primesUpTo(2);
        assertEquals(1, primes.length);
        assertEquals(2, primes[0]);
    }

    @Test
    public void testPrimesUpTo100() {
        int[] truePrimes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        };
        int[] primes = Lib.primesUpTo(100);
        assertEquals(25, primes.length);
        for (int i=0; i<primes.length; i++) {
            assertEquals(truePrimes[i], primes[i]);
        }
    }

    @Test
    public void testPrimeFactorizationSquare() {
        PrimePower[] facs = Lib.primeFactorization(100);
        assertEquals(2, facs.length);
        assertEquals(2, facs[0].prime);
        assertEquals(2, facs[0].exp);
        assertEquals(5, facs[1].prime);
        assertEquals(2, facs[1].exp);
    }

    @Test
    public void testPrimeFactorizationLCM() {
        PrimePower[] facs = Lib.primeFactorization(2520);
        assertEquals(4, facs.length);
        assertEquals(2, facs[0].prime);
        assertEquals(3, facs[0].exp);
        assertEquals(3, facs[1].prime);
        assertEquals(2, facs[1].exp);
        assertEquals(5, facs[2].prime);
        assertEquals(1, facs[2].exp);
        assertEquals(7, facs[3].prime);
        assertEquals(1, facs[3].exp);
    }

    @Test
    public void testPrimeFactorizationPrime() {
        PrimePower[] facs = Lib.primeFactorization(8675309);
        assertEquals(1, facs.length);
        assertEquals(8675309, facs[0].prime);
        assertEquals(1, facs[0].exp);
    }

    @Test
    public void testPrimeFactorizationOne() {
        PrimePower[] facs = Lib.primeFactorization(1);
        assertEquals(0, facs.length);
    }

    @Test
    public void testTriangleNumbers() {
        assertEquals(1, Lib.triangleNumber(1));
        assertEquals(3, Lib.triangleNumber(2));
        assertEquals(6, Lib.triangleNumber(3));
        assertEquals(10, Lib.triangleNumber(4));
        assertEquals(15, Lib.triangleNumber(5));
        assertEquals(21, Lib.triangleNumber(6));
        assertEquals(28, Lib.triangleNumber(7));
    }

    @Test
    public void testNumDivisors() {
        long[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47};
        assertEquals(1, Lib.numDivisors(1));
        for (long p : primes) {
            assertEquals(2, Lib.numDivisors(p));
            assertEquals(3, Lib.numDivisors(p*p));
            assertEquals(4, Lib.numDivisors(p*p*p));
        }

        for (long p : primes) {
            for (long q : primes) {
                if (p <= q) continue;
                assertEquals(4, Lib.numDivisors(p*q));
                assertEquals(6, Lib.numDivisors(p*p*q));
                assertEquals(9, Lib.numDivisors(p*p*q*q));
            }
        }

        for (long p : primes) {
            for (long q : primes) {
                if (p <= q) continue;
                for (long s : primes) {
                    if (q <= s) continue;
                    assertEquals(8, Lib.numDivisors(p*q*s));
                    assertEquals(12, Lib.numDivisors(p*p*q*s));
                    assertEquals(18, Lib.numDivisors(p*p*q*q*s));
                    assertEquals(27, Lib.numDivisors(p*p*q*q*s*s));
                    assertEquals(16, Lib.numDivisors(p*p*p*q*s));
                    assertEquals(24, Lib.numDivisors(p*p*p*q*q*s));
                    assertEquals(36, Lib.numDivisors(p*p*p*q*q*s*s));
                    assertEquals(48, Lib.numDivisors(p*p*p*q*q*q*s*s));
                    assertEquals(64, Lib.numDivisors(p*p*p*q*q*q*s*s*s));
                }
            }
        }
    }

    @Test
    public void testCollatzWithLookup() {
        int[] collatz = new int[10];
        collatz[1] = 1;

        int[] answer = {0,1,2,8,3,6,9,17,4,20};

        for (int i=0; i<collatz.length; i++) {
            collatz[i] = Lib.collatzWithLookup(i, collatz);
            assertEquals(answer[i], collatz[i]);
        }
    }
}
