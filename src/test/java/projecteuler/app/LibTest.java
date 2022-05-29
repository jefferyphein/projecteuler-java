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
}
