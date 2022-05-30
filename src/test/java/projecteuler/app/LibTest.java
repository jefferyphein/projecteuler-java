package projecteuler.app;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Vector;

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
        Vector<String> lines = Lib.readLines("./data/008/input");
        assertEquals(20, lines.size());
    }

    @Test
    public void testReadLinesFileDoesNotExist() {
        Vector<String> lines = Lib.readLines("./data/does_not_exist");
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
}
