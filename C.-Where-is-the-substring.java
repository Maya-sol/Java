import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String pattern = br.readLine();
        String line = br.readLine();
        int len1 = pattern.length(), len2 = line.length();
        int i = 0;
        while (i < len2) {
            if (line.startsWith(pattern, i)) {
                pw.print(i + " ");
            }
            i += 1;
        }
        pw.flush();
        pw.close();
        br.close();
    }

}
