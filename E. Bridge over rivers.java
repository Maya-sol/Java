import java.util.*;
import java.io.*;

class Point {
    int x, y;

    Point() {
        x = 0;
        y = 0;
    }

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

    boolean pointsOnSameSegment(Point b, Point c, Point d) {
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
        if (or1 == 0 && pointsOnSameSegment(a, c, b)) {
            return true;
        }
        if (or2 == 0 && pointsOnSameSegment(a, d, b)) {
            return true;
        }
        if (or3 == 0 && pointsOnSameSegment(c, a, d)) {
            return true;
        }
        if (or4 == 0 && pointsOnSameSegment(c, b, d)) {
            return true;
        }
        return false;
    }

    int finalResult(BufferedReader buffer) {
        try {
            int number = 0;
            String[] parts = buffer.readLine().split(" ");
            Point a = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            Point b = new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
            number = Integer.parseInt(buffer.readLine());
            int result = 0;
            for (int i = 0; i < number; ++i) {
                parts = buffer.readLine().split(" ");
                Point c = new Point(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
                Point d = new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3]));
                if (a.intersect(b, c, d)) {
                    ++result;
                }
            }
            return result;
        } catch (Exception e) {
            System.err.println("Application failed: " + e.getMessage());
            System.exit(1);
            return -1;
        }
    }
}


public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            Point a = new Point();
            int result = a.finalResult(buffer);
            System.out.println(result);
            buffer.close();

        } catch (Exception e) {
            System.err.println("Application failed: " + e.getMessage());
            System.exit(1);
        }
    }
}
