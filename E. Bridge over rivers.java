import java.util.*;
import java.io.*;

class Point {
    int x, y;

    Point(int a, int b) {
        x = a;
        y = b;
    }

    int orientation(Point b, Point c, Point d) {
        int result = (c.y - b.y) * (d.x - c.x) - (c.x - b.x) * (d.y - c.y);
        if (result == 0) {
            return 0;
        }
        if (result > 0) {
            return 1;
        }
        return -1;
    }

    boolean onSegment(Point b, Point c, Point d) {
        if (b.x <= c.x && c.x <= d.x && b.y <= c.y && c.y <= d.y) {
            return true;
        }
        if (b.x <= c.x && c.x <= d.x && b.y >= c.y && c.y >= d.y) {
            return true;
        }
        if (b.x >= c.x && c.x >= d.x && b.y >= c.y && c.y >= d.y) {
            return true;
        }
        if (b.x >= c.x && c.x >= d.x && b.y <= c.y && c.y <= d.y) {
            return true;
        }
        return false;
    }

    boolean intersect(Point b, Point c, Point d) {
        int or1 = 0, or2 = 0, or3 = 0, or4 = 0;
        Point a = new Point(x, y);
        or1 = orientation(a, b, c);
        or2 = orientation(a, b, d);
        or3 = orientation(c, d, a);
        or4 = orientation(c, d, b);
        if (or1 != or2 && or3 != or4) {
            return true;
        }
        if (or1 == 0 && onSegment(a, c, b)) {
            return true;
        }
        if (or2 == 0 && onSegment(a, d, b)) {
            return true;
        }
        if (or3 == 0 && onSegment(c, a, d)) {
            return true;
        }
        if (or4 == 0 && onSegment(c, b, d)) {
            return true;
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int number = 0, result = 0;
        String[] parts = br.readLine().split(" ");
        Point a = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        Point b = new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
        number = Integer.parseInt(br.readLine());
        for (int i = 0; i < number; i++) {
            parts = br.readLine().split(" ");
            Point c = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            Point d = new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            if (a.intersect(b, c, d)) {
                result += 1;
            }
        }
        pw.println(result);


        pw.flush();
        pw.close();
        br.close();
    }
}
