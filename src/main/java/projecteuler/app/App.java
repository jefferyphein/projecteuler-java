package projecteuler.app;

/**
 * Problem launcher application.
 *
 * The first positional argument to the entry point main() function is the
 * Project Euler problem to run. Each problem returns a String representation
 * of its solution, which is then printed to stdout.
 *
 * If an invalid problem ID is provided, an error will be displayed.
 */
public class App {
    public static void main( String[] args ) {
        // Provide usage message if no arguments are provided.
        if (args.length == 0) {
            System.err.println("Usage: app <problem-id>");
            return;
        }

        // Convert positional argument to problem ID.
        int problem_id = Integer.parseInt(args[0]);
        Euler problem = null;

        // Create problem class from problem ID.
        switch (problem_id) {
        case 1: problem = new Euler001(); break;
        case 2: problem = new Euler002(); break;
        default:
            System.err.format("ERROR: Problem ID #%d does not exist.\n", problem_id);
            return;
        }

        // Run the selected problem and display the answer.
        System.out.println(problem.run());
    }
}
