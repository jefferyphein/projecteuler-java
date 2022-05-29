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
}
