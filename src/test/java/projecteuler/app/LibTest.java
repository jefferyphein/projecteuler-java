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
}
