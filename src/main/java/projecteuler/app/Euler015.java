/*
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
 *
 * [ See image at https://projecteuler.net/problem=15 ]
 *
 * How many such routes are there through a 20×20 grid?
 */

/*
 * You always have to move right or down. Since the grid is 20x20, you must
 * make 20 right movements and 20 down movements. The only choice you have is
 * the ordering of these 40 movements. Therefore, the number of distinct routes
 * through the grid is (40 choose 20) = 40!/(20!20!) = 137846528820
 */

package projecteuler.app;

public final class Euler015 implements Euler {
    public static void main(String[] args) {
        System.out.println(new Euler015().run());
    }

    public String run() {
        return "137846528820";
    }
}
