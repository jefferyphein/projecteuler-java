package projecteuler.app;

import java.util.Map;
import java.util.HashMap;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;

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

    private static Map<String, Level> loglevels;

    static {
        loglevels = new HashMap<>();
        loglevels.put("debug", Level.DEBUG);
        loglevels.put("info", Level.INFO);
        loglevels.put("warn", Level.WARN);
        loglevels.put("error", Level.ERROR);
        loglevels.put("fatal", Level.FATAL);
        loglevels.put("trace", Level.TRACE);
    }

    public static void RunProblem(int problem_id) {
        Euler problem = null;

        // Create problem class from problem ID.
        switch (problem_id) {
        case 1:   problem = new Euler001(); break;
        case 2:   problem = new Euler002(); break;
        case 3:   problem = new Euler003(); break;
        case 4:   problem = new Euler004(); break;
        case 5:   problem = new Euler005(); break;
        case 6:   problem = new Euler006(); break;
        case 7:   problem = new Euler007(); break;
        case 8:   problem = new Euler008(); break;
        case 9:   problem = new Euler009(); break;
        case 10:  problem = new Euler010(); break;
        case 11:  problem = new Euler011(); break;
        case 12:  problem = new Euler012(); break;
        case 13:  problem = new Euler013(); break;
        case 14:  problem = new Euler014(); break;
        default:
            System.out.println(
                BLUE + String.format("Problem ID #%d: ", problem_id) +
                RED + "does not exist" + RESET);
            return;
        }

        // Run and time the selected problem.
        long startTime = System.nanoTime();
        String answer = problem.run();
        long endTime = System.nanoTime();
        double duration = (double)(endTime - startTime) / 1000000.0;

        System.out.println(
            BLUE + String.format("Problem ID #%d: ", problem_id) +
            GREEN + answer + RESET + String.format(" (%.4f ms)", duration));
    }

    public static void main(String[] args) {
        // Set loglevel from environment variable.
        String loglevel = System.getenv("EULER_LOGLEVEL");
        if (loglevel != null) {
            loglevel = loglevel.toLowerCase();
        }
        if (loglevels.containsKey(loglevel)) {
            // https://stackoverflow.com/a/23434603/19266495
            LoggerContext ctx = (LoggerContext)LogManager.getContext(false);
            Configuration config = ctx.getConfiguration();
            LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);
            loggerConfig.setLevel(loglevels.get(loglevel));
            ctx.updateLoggers();
        }

        // Provide usage message if no arguments are provided.
        if (args.length == 0) {
            System.err.println("Usage: app <problem-id> [<problem-id> [...]]");
            System.err.println("Examples:");
            System.err.println("  app 1 2 3     # run problems 1, 2, and 3");
            System.err.println("  app 1..6      # run problems 1 through 6");
            return;
        }

        for (int i=0; i<args.length; i++) {
            if (args[i].contains("..")) {
                // Run range-based problems.
                int index = args[i].indexOf("..");
                int lower = Integer.parseInt(args[i].substring(0, index));
                int upper = Integer.parseInt(args[i].substring(index+2));

                for (int j=lower; j<=upper; j++) {
                    RunProblem(j);
                }
            }
            else {
                // Convert argument to problem ID.
                int problem_id = Integer.parseInt(args[i]);
                RunProblem(problem_id);
            }
        }
    }
}
