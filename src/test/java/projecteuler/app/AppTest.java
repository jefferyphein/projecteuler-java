package projecteuler.app;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for Project Euler problems and libraries.
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
}
