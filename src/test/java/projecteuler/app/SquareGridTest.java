package projecteuler.app;

import static org.junit.Assert.*;

import org.junit.Test;
import java.lang.IllegalArgumentException;

public class SquareGridTest {
    private SquareGrid m_grid;

    public SquareGridTest() {
        m_grid = new SquareGrid(new int[][]{{1,2},{3,4}});
    }

    @Test
    public void verifyCorrectness() {
        assertEquals(2, m_grid.size());
        assertArrayEquals(new int[]{1,2}, m_grid.row(0));
        assertArrayEquals(new int[]{3,4}, m_grid.row(1));
    }

    @Test
    public void verifyTranspose() {
        m_grid.transpose();
        assertArrayEquals(new int[]{1,3}, m_grid.row(0));
        assertArrayEquals(new int[]{2,4}, m_grid.row(1));
    }

    @Test
    public void verifyFlipHorizontal() {
        m_grid.flip_horizontal();
        assertArrayEquals(new int[]{2,1}, m_grid.row(0));
        assertArrayEquals(new int[]{4,3}, m_grid.row(1));
    }

    @Test
    public void verifyDiagonal() {
        assertArrayEquals(new int[]{1,4}, m_grid.diagonal(0));
        assertArrayEquals(new int[]{3}, m_grid.diagonal(-1));
        assertArrayEquals(new int[]{2}, m_grid.diagonal(1));
    }

    @Test
    public void verifyTrowWhenNotSquare() {
        try {
            SquareGrid rectangle = new SquareGrid(new int[][]{{1,2,3},{4,5,6}});
            assertFalse(true);
        }
        catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }
}
