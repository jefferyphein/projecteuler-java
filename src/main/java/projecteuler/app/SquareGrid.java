package projecteuler.app;

import java.lang.IllegalArgumentException;
import java.util.stream.Stream;

public class SquareGrid {
    private int[][] m_grid;

    public SquareGrid(int[][] matrix) {
        int row_count = matrix.length;
        for (int[] row : matrix) {
            if (row.length != row_count) {
                throw new IllegalArgumentException("Matrix must be square.");
            }
        }
        m_grid = matrix;
    }

    public int size() {
        return m_grid.length;
    }

    public int[] row(int index) {
        return m_grid[index];
    }

    public void transpose() {
        for (int i=0; i<m_grid.length-1; i++) {
            for (int j=i+1; j<m_grid.length; j++) {
                int temp = m_grid[i][j];
                m_grid[i][j] = m_grid[j][i];
                m_grid[j][i] = temp;
            }
        }
    }

    public int[] diagonal(int offset) {
        int row = offset < 0 ? -offset : 0;
        int col = offset > 0 ? offset : 0;

        int length = Math.min(m_grid.length-row, m_grid.length-col);
        int[] array = new int[length];

        for (int i=0; i<length; i++) {
            array[i] = m_grid[i+row][i+col];
        }

        return array;
    }

    public void flip_horizontal() {
        for (int i=0; i<m_grid.length; i++) {
            for (int j=0; j<m_grid.length/2; j++) {
                int temp = m_grid[i][j];
                m_grid[i][j] = m_grid[i][m_grid.length-1-j];
                m_grid[i][m_grid.length-1-j] = temp;
            }
        }
    }
}
