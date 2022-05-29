package projecteuler.app;

import java.util.Vector;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Lib {
    public static boolean isPalindrome(long N) {
        String strN = Long.toString(N);
        return strN.equals(new StringBuilder(strN).reverse().toString());
    }

    public static Vector<String> readLines(String filename) throws IOException {
        Vector<String> lines = new Vector<String>();

        try (Stream<String> stream = Files.lines(Paths.get(filename))) {
            stream.forEach(s -> lines.addElement(s));
        }

        return lines;
    }
}
