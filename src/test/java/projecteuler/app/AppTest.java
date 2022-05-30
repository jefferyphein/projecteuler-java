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

    @Test
    public void verifyProblem007() {
        assertEquals(new Euler007().run(), "104759");
    }

    @Test
    public void verifyProblem008() {
        assertEquals(new Euler008().run(), "23514624000");
    }

    @Test
    public void verifyProblem009() {
        assertEquals(new Euler009().run(), "31875000");
    }

    @Test
    public void verifyProblem010() {
        assertEquals(new Euler010().run(), "142913828922");
    }
}
