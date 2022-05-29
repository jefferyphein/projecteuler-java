package projecteuler.app;

/**
 * Problem launcher application.
 *
 * Run and display the solution to each Project Euler problem ID provided as
 * a positional argument to the main() entry point.
 */
public class App {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";

    public static void main( String[] args ) {
        // Provide usage message if no arguments are provided.
        if (args.length == 0) {
            System.err.println("Usage: app <problem-id> [<problem-id> [...]]");
            return;
        }

        for (int i=0; i<args.length; i++) {
            // Convert positional argument to problem ID.
            int problem_id = Integer.parseInt(args[i]);
            Euler problem = null;

            // Create problem class from problem ID.
            switch (problem_id) {
            case 1: problem = new Euler001(); break;
            case 2: problem = new Euler002(); break;
            case 3: problem = new Euler003(); break;
            case 4: problem = new Euler004(); break;
            case 5: problem = new Euler005(); break;
            case 6: problem = new Euler006(); break;
            default:
                System.out.println(
                    BLUE + String.format("Problem ID #%d: ", problem_id) +
                    RED + "does not exist" + RESET);
                continue;
            }

            // Run the selected problem and display the answer.
            System.out.println(
                BLUE + String.format("Problem ID #%d: ", problem_id) +
                GREEN + problem.run() + RESET);
        }
    }
}
