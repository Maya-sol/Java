import java.util.*;
import java.io.*;

class PatternNum {
    void patternRepetitions(String pattern, String line) {
        try {
            PrintWriter printWriter = new PrintWriter(System.out);
            int len1 = pattern.length(), len2 = line.length();
            int i = 0;

            while (i < len2) {
                if (line.startsWith(pattern, i)) {
                    printWriter.print(i + " ");
                }
                ++i;
            }

            printWriter.flush();
            printWriter.close();
            
        } catch (Exception e) {
            System.err.println("Application failed: " + e.getMessage());
            System.exit(1);
        }

    }
}

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader buffered = new BufferedReader(new InputStreamReader(System.in));
            String pattern = buffered.readLine();
            String line = buffered.readLine();
            PatternNum pat = new PatternNum();
            pat.patternRepetitions(pattern, line);
            buffered.close();
        } catch (Exception e) {
            System.err.println("Application failed: " + e.getMessage());
            System.exit(1);
        }

    }
}
