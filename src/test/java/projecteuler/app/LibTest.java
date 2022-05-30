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
        assertEquals(lines.size(), 20);
    }

    @Test
    public void testReadLinesFileDoesNotExist() {
        Vector<String> lines = Lib.readLines("./data/does_not_exist");
        assertEquals(lines, null);
    }

    @Test
    public void testPrimesUpToEmpty() {
        int[] primes = Lib.primesUpTo(1);
        assertEquals(primes.length, 0);
    }

    @Test
    public void testPrimesUpToTwo() {
        int[] primes = Lib.primesUpTo(2);
        assertEquals(primes.length, 1);
        assertEquals(primes[0], 2);
    }

    @Test
    public void testPrimesUpTo100() {
        int[] truePrimes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
        };
        int[] primes = Lib.primesUpTo(100);
        assertEquals(primes.length, 25);
        for (int i=0; i<primes.length; i++) {
            assertEquals(primes[i], truePrimes[i]);
        }
    }
}
