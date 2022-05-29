package projecteuler.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Project Euler problems.
 */
public class AppTest {
    @Test
    public void verifyProblem001() {
        assertEquals(new Euler001().run(), "233168");
    }

    @Test
    public void verifyProblem002() {
        assertEquals(new Euler002().run(), "4613732");
    }

    @Test
    public void verifyProblem003() {
        assertEquals(new Euler003().run(), "6857");
    }

    @Test
    public void verifyProblem004() {
        assertEquals(new Euler004().run(), "906609");
    }

    @Test
    public void verifyProblem005() {
        assertEquals(new Euler005().run(), "232792560");
    }

    @Test
    public void verifyProblem006() {
        assertEquals(new Euler006().run(), "25164150");
    }
}
